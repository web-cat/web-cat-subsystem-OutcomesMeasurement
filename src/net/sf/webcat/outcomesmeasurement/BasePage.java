/*==========================================================================*\
 |  $Id$
 |*-------------------------------------------------------------------------*|
 |  Copyright (C) 2009 Virginia Tech
 |
 |  This file is part of Web-CAT.
 |
 |  Web-CAT is free software; you can redistribute it and/or modify
 |  it under the terms of the GNU Affero General Public License as published
 |  by the Free Software Foundation; either version 3 of the License, or
 |  (at your option) any later version.
 |
 |  Web-CAT is distributed in the hope that it will be useful,
 |  but WITHOUT ANY WARRANTY; without even the implied warranty of
 |  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 |  GNU General Public License for more details.
 |
 |  You should have received a copy of the GNU Affero General Public License
 |  along with Web-CAT; if not, see <http://www.gnu.org/licenses/>.
\*==========================================================================*/

package net.sf.webcat.outcomesmeasurement;

import java.util.Calendar;
import java.util.GregorianCalendar;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;
import net.sf.webcat.core.AuthenticationDomain;
import net.sf.webcat.core.Department;
import net.sf.webcat.core.Semester;
import net.sf.webcat.core.WCComponent;

//-------------------------------------------------------------------------
/**
 *  Common page behaviors for this subsystem.
 *
 *  @author Stephen Edwards
 *  @author Last changed by $Author$
 *  @version $Revision$, $Date$
*/
public class BasePage
    extends WCComponent
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new object.
     *
     * @param context The context to use
     */
    public BasePage(WOContext context)
    {
        super(context);
    }


    //~ KVC Attributes (must be public) .......................................

    public Semester semester;
    public AccreditingBody abet;
    public Department dept;
    public Program program;


    //~ Methods ...............................................................

    // ----------------------------------------------------------
//    public void appendToResponse(WOResponse response, WOContext context)
//    {
//        ensureSemester();
//        ensureABET();
//        ensureDepartment();
//        ensureProgram();
//        super.appendToResponse(response, context);
//    }


    // ----------------------------------------------------------
    public void awake()
    {
        super.awake();
        ensureSemester();
        ensureABET();
        ensureDepartment();
        ensureProgram();
    }


    // ----------------------------------------------------------
    protected void ensureSemester()
    {
        if (semester == null)
        {
            NSArray<Semester> semesters =
                Semester.allObjectsOrderedByStartDate(localContext());
            if (semesters.size() > 0)
            {
                semester = semesters.get(0);
            }
            else
            {
                Calendar now = new GregorianCalendar();
                int year = now.get(Calendar.YEAR);
                int season = Semester.defaultSemesterFor(now);
                semester = Semester.create(
                    localContext(),
                    season,
                    Semester.defaultStartingDate(season, year, null),
                    Semester.defaultEndingDate(season, year, null),
                    year);
                applyLocalChanges();
            }
        }
    }


    // ----------------------------------------------------------
    protected void ensureABET()
    {
        if (abet == null)
        {
            NSArray<AccreditingBody> candidates =
                AccreditingBody.objectsMatchingQualifier(localContext(),
                    AccreditingBody.name.is("ABET"));
            if (candidates.size() > 0)
            {
                abet = candidates.get(0);
            }
            else
            {
                abet = AccreditingBody.create(localContext(), "ABET");
                applyLocalChanges();
            }
        }
    }


    // ----------------------------------------------------------
    protected void ensureDepartment()
    {
        // make sure we have a department created
        if (dept == null)
        {
            NSArray<Department> candidates =
                Department.objectsMatchingQualifier(localContext(),
                    Department.abbreviation.is("CS"));
            if (candidates.size() > 0)
            {
                dept = candidates.get(0);
            }
            else
            {
                dept = Department.create(localContext(), "CS");
                dept.setName("Computer Science");
                dept.setInstitution(AuthenticationDomain.defaultDomain());
                applyLocalChanges();
            }
        }
    }


    // ----------------------------------------------------------
    protected void ensureProgram()
    {
        ensureDepartment();

        // make sure we have a program created
        if (program == null)
        {
            NSArray<Program> candidates = Program.objectsMatchingQualifier(
                localContext(), Program.department.is(dept));

            if (candidates.size() > 0)
            {
                program = candidates.get(0);
            }
            else
            {
                program = Program.create(localContext(), dept);
                program.setName("Bachelor of Science in Computer Science");
                applyLocalChanges();
            }
        }
    }
}
