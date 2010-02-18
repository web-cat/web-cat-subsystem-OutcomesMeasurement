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

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSArray;

//-------------------------------------------------------------------------
/**
 *  View outcomes for an external accrediting body.
 *
 *  @author Stephen Edwards
 *  @author Last changed by $Author$
 *  @version $Revision$, $Date$
*/
public class AccreditingBodyOutcomesPage
    extends BasePage
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new object.
     *
     * @param context The context to use
     */
    public AccreditingBodyOutcomesPage(WOContext context)
    {
        super(context);
    }


    //~ KVC Attributes (must be public) .......................................

    public NSArray<ExternalOutcome> outcomes;
    public ExternalOutcome outcome;


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    public void appendToResponse(WOResponse response, WOContext context)
    {
        if (outcomes == null)
        {
            outcomes = ExternalOutcome.objectsMatchingQualifier(localContext(),
                ExternalOutcome.accreditingBody.is(abet),
                ExternalOutcome.microLabel.ascs());
        }
        super.appendToResponse(response, context);
    }
}