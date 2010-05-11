/*==========================================================================*\
 |  $Id$
 |*-------------------------------------------------------------------------*|
 |  Copyright (C) 2006-2009 Virginia Tech
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

package org.webcat.outcomesmeasurement;

import org.webcat.core.User;

import com.webobjects.eocontrol.EOEditingContext;

// -------------------------------------------------------------------------
/**
 * TODO: place a real description here.
 *
 * @author
 * @author  latest changes by: $Author$
 * @version $Revision$, $Date$
 */
public class StudentAnswer
    extends _StudentAnswer
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new StudentAnswer object.
     */
    public StudentAnswer()
    {
        super();
    }


    //~ Methods ...............................................................

    public static StudentAnswer createStudentAnswer(Coursework cw,
    												String points,
    												User user,
    												EOEditingContext ec){
    	StudentAnswer sa = new StudentAnswer();
    	ec.insertObject(sa);
    	if (cw == null) System.out.println("cw is null");
    	sa.setCourseworkRelationship(cw);
    	sa.setPointsEarned(Double.valueOf(points));
    	sa.setUserRelationship(user);
    	ec.saveChanges();
    	return sa;
    }
}
