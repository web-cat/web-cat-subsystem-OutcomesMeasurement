/*==========================================================================*\
 |  _ExternalOutcome.java
 |*-------------------------------------------------------------------------*|
 |  Created by eogenerator
 |  DO NOT EDIT.  Make changes to ExternalOutcome.java instead.
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

package net.sf.webcat.outcomesmeasurement;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import er.extensions.eof.ERXKey;
import org.apache.log4j.Logger;

// -------------------------------------------------------------------------
/**
 * An automatically generated EOGenericRecord subclass.  DO NOT EDIT.
 * To change, use EOModeler, or make additions in
 * ExternalOutcome.java.
 *
 * @author Generated by eogenerator
 * @version version suppressed to control auto-generation
 */
public abstract class _ExternalOutcome
    extends net.sf.webcat.outcomesmeasurement.Outcome
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new _ExternalOutcome object.
     */
    public _ExternalOutcome()
    {
        super();
    }


    // ----------------------------------------------------------
    /**
     * A static factory method for creating a new
     * ExternalOutcome object given required
     * attributes and relationships.
     * @param editingContext The context in which the new object will be
     * inserted
     * @param accreditingBody
     * @return The newly created object
     */
    public static ExternalOutcome create(
        EOEditingContext editingContext,
        net.sf.webcat.outcomesmeasurement.AccreditingBody accreditingBodyValue
        )
    {
        ExternalOutcome eoObject = (ExternalOutcome)
            EOUtilities.createAndInsertInstance(
                editingContext,
                _ExternalOutcome.ENTITY_NAME);
        eoObject.setAccreditingBodyRelationship(accreditingBodyValue);
        return eoObject;
    }


    // ----------------------------------------------------------
    /**
     * Get a local instance of the given object in another editing context.
     * @param editingContext The target editing context
     * @param eo The object to import
     * @return An instance of the given object in the target editing context
     */
    public static ExternalOutcome localInstance(
        EOEditingContext editingContext, ExternalOutcome eo)
    {
        return (eo == null)
            ? null
            : (ExternalOutcome)EOUtilities.localInstanceOfObject(
                editingContext, eo);
    }


    // ----------------------------------------------------------
    /**
     * Look up an object by id number.  Assumes the editing
     * context is appropriately locked.
     * @param ec The editing context to use
     * @param id The id to look up
     * @return The object, or null if no such id exists
     */
    public static ExternalOutcome forId(
        EOEditingContext ec, int id )
    {
        ExternalOutcome obj = null;
        if (id > 0)
        {
            NSArray<ExternalOutcome> results =
                objectsMatchingValues(ec, "id", new Integer(id));
            if (results != null && results.count() > 0)
            {
                obj = results.objectAtIndex(0);
            }
        }
        return obj;
    }


    // ----------------------------------------------------------
    /**
     * Look up an object by id number.  Assumes the editing
     * context is appropriately locked.
     * @param ec The editing context to use
     * @param id The id to look up
     * @return The object, or null if no such id exists
     */
    public static ExternalOutcome forId(
        EOEditingContext ec, String id )
    {
        return forId( ec, er.extensions.foundation.ERXValueUtilities.intValue( id ) );
    }


    //~ Constants (for key names) .............................................

    // Attributes ---
    // To-one relationships ---
    public static final String ACCREDITING_BODY_KEY = "accreditingBody";
    public static final ERXKey<net.sf.webcat.outcomesmeasurement.AccreditingBody> accreditingBody =
        new ERXKey<net.sf.webcat.outcomesmeasurement.AccreditingBody>(ACCREDITING_BODY_KEY);
    // To-many relationships ---
    public static final String OUTCOME_PAIRS_KEY = "outcomePairs";
    public static final ERXKey<net.sf.webcat.outcomesmeasurement.OutcomePair> outcomePairs =
        new ERXKey<net.sf.webcat.outcomesmeasurement.OutcomePair>(OUTCOME_PAIRS_KEY);
    // Fetch specifications ---
    public static final String ENTITY_NAME = "ExternalOutcome";


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Get a local instance of this object in another editing context.
     * @param editingContext The target editing context
     * @return An instance of this object in the target editing context
     */
    public ExternalOutcome localInstance(EOEditingContext editingContext)
    {
        return (ExternalOutcome)EOUtilities.localInstanceOfObject(
            editingContext, this);
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the entity pointed to by the <code>accreditingBody</code>
     * relationship.
     * @return the entity in the relationship
     */
    public net.sf.webcat.outcomesmeasurement.AccreditingBody accreditingBody()
    {
        return (net.sf.webcat.outcomesmeasurement.AccreditingBody)storedValueForKey( "accreditingBody" );
    }


    // ----------------------------------------------------------
    /**
     * Set the entity pointed to by the <code>accreditingBody</code>
     * relationship (DO NOT USE--instead, use
     * <code>setAccreditingBodyRelationship()</code>.
     * This method is provided for WebObjects use.
     *
     * @param value The new entity to relate to
     */
    public void setAccreditingBody( net.sf.webcat.outcomesmeasurement.AccreditingBody value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setAccreditingBody("
                + value + "): was " + accreditingBody() );
        }
        takeStoredValueForKey( value, "accreditingBody" );
    }


    // ----------------------------------------------------------
    /**
     * Set the entity pointed to by the <code>accreditingBody</code>
     * relationship.  This method is a type-safe version of
     * <code>addObjectToBothSidesOfRelationshipWithKey()</code>.
     *
     * @param value The new entity to relate to
     */
    public void setAccreditingBodyRelationship(
        net.sf.webcat.outcomesmeasurement.AccreditingBody value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setAccreditingBodyRelationship("
                + value + "): was " + accreditingBody() );
        }
        if ( value == null )
        {
            net.sf.webcat.outcomesmeasurement.AccreditingBody object = accreditingBody();
            if ( object != null )
                removeObjectFromBothSidesOfRelationshipWithKey( object, "accreditingBody" );
        }
        else
        {
            addObjectToBothSidesOfRelationshipWithKey( value, "accreditingBody" );
        }
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the entities pointed to by the <code>outcomePairs</code>
     * relationship.
     * @return an NSArray of the entities in the relationship
     */
    @SuppressWarnings("unchecked")
    public NSArray<net.sf.webcat.outcomesmeasurement.OutcomePair> outcomePairs()
    {
        return (NSArray)storedValueForKey( "outcomePairs" );
    }


    // ----------------------------------------------------------
    /**
     * Replace the list of entities pointed to by the
     * <code>outcomePairs</code> relationship.
     *
     * @param value The new set of entities to relate to
     */
    public void setOutcomePairs( NSMutableArray<net.sf.webcat.outcomesmeasurement.OutcomePair>  value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setOutcomePairs("
                + value + "): was " + outcomePairs() );
        }
        takeStoredValueForKey( value, "outcomePairs" );
    }


    // ----------------------------------------------------------
    /**
     * Add a new entity to the <code>outcomePairs</code>
     * relationship (DO NOT USE--instead, use
     * <code>addToOutcomePairsRelationship()</code>.
     * This method is provided for WebObjects use.
     *
     * @param value The new entity to relate to
     */
    public void addToOutcomePairs( net.sf.webcat.outcomesmeasurement.OutcomePair value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "addToOutcomePairs("
                + value + "): was " + outcomePairs() );
        }
        NSMutableArray<net.sf.webcat.outcomesmeasurement.OutcomePair> array =
            (NSMutableArray<net.sf.webcat.outcomesmeasurement.OutcomePair>)outcomePairs();
        willChange();
        array.addObject( value );
    }


    // ----------------------------------------------------------
    /**
     * Remove a specific entity from the <code>outcomePairs</code>
     * relationship (DO NOT USE--instead, use
     * <code>removeFromOutcomePairsRelationship()</code>.
     * This method is provided for WebObjects use.
     *
     * @param value The entity to remove from the relationship
     */
    public void removeFromOutcomePairs( net.sf.webcat.outcomesmeasurement.OutcomePair value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "RemoveFromOutcomePairs("
                + value + "): was " + outcomePairs() );
        }
        NSMutableArray<net.sf.webcat.outcomesmeasurement.OutcomePair> array =
            (NSMutableArray<net.sf.webcat.outcomesmeasurement.OutcomePair>)outcomePairs();
        willChange();
        array.removeObject( value );
    }


    // ----------------------------------------------------------
    /**
     * Add a new entity to the <code>outcomePairs</code>
     * relationship.
     *
     * @param value The new entity to relate to
     */
    public void addToOutcomePairsRelationship( net.sf.webcat.outcomesmeasurement.OutcomePair value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "addToOutcomePairsRelationship("
                + value + "): was " + outcomePairs() );
        }
        addObjectToBothSidesOfRelationshipWithKey(
            value, "outcomePairs" );
    }


    // ----------------------------------------------------------
    /**
     * Remove a specific entity from the <code>outcomePairs</code>
     * relationship.
     *
     * @param value The entity to remove from the relationship
     */
    public void removeFromOutcomePairsRelationship( net.sf.webcat.outcomesmeasurement.OutcomePair value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "removeFromOutcomePairsRelationship("
                + value + "): was " + outcomePairs() );
        }
        removeObjectFromBothSidesOfRelationshipWithKey(
            value, "outcomePairs" );
    }


    // ----------------------------------------------------------
    /**
     * Create a brand new object that is a member of the
     * <code>outcomePairs</code> relationship.
     *
     * @return The new entity
     */
    public net.sf.webcat.outcomesmeasurement.OutcomePair createOutcomePairsRelationship()
    {
        if (log.isDebugEnabled())
        {
            log.debug( "createOutcomePairsRelationship()" );
        }
        EOClassDescription eoClassDesc = EOClassDescription
            .classDescriptionForEntityName( "OutcomePair" );
        EOEnterpriseObject eoObject = eoClassDesc
            .createInstanceWithEditingContext( editingContext(), null );
        editingContext().insertObject( eoObject );
        addObjectToBothSidesOfRelationshipWithKey(
            eoObject, "outcomePairs" );
        return (net.sf.webcat.outcomesmeasurement.OutcomePair)eoObject;
    }


    // ----------------------------------------------------------
    /**
     * Remove and then delete a specific entity that is a member of the
     * <code>outcomePairs</code> relationship.
     *
     * @param value The entity to remove from the relationship and then delete
     */
    public void deleteOutcomePairsRelationship( net.sf.webcat.outcomesmeasurement.OutcomePair value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "deleteOutcomePairsRelationship("
                + value + "): was " + outcomePairs() );
        }
        removeObjectFromBothSidesOfRelationshipWithKey(
            value, "outcomePairs" );
        editingContext().deleteObject( value );
    }


    // ----------------------------------------------------------
    /**
     * Remove (and then delete, if owned) all entities that are members of the
     * <code>outcomePairs</code> relationship.
     */
    public void deleteAllOutcomePairsRelationships()
    {
        if (log.isDebugEnabled())
        {
            log.debug( "deleteAllOutcomePairsRelationships(): was "
                + outcomePairs() );
        }
        for (net.sf.webcat.outcomesmeasurement.OutcomePair object : outcomePairs())
        {
            deleteOutcomePairsRelationship(object);
        }
    }


    // ----------------------------------------------------------
    /**
     * Retrieve objects using a fetch specification.
     *
     * @param context The editing context to use
     * @param fspec The fetch specification to use
     *
     * @return an NSArray of the entities retrieved
     */
    @SuppressWarnings("unchecked")
    public static NSArray<ExternalOutcome> objectsWithFetchSpecification(
        EOEditingContext context,
        EOFetchSpecification fspec)
    {
        return context.objectsWithFetchSpecification(fspec);
    }


    // ----------------------------------------------------------
    /**
     * Retrieve all objects of this type.
     *
     * @param context The editing context to use
     *
     * @return an NSArray of the entities retrieved
     */
    public static NSArray<ExternalOutcome> allObjects(
        EOEditingContext context)
    {
        return objectsMatchingQualifier(context, null, null);
    }


    // ----------------------------------------------------------
    /**
     * Retrieve objects using a qualifier.
     *
     * @param context The editing context to use
     * @param qualifier The qualifier to use
     *
     * @return an NSArray of the entities retrieved
     */
    public static NSArray<ExternalOutcome> objectsMatchingQualifier(
        EOEditingContext context,
        EOQualifier qualifier)
    {
        return objectsMatchingQualifier(context, qualifier, null);
    }


    // ----------------------------------------------------------
    /**
     * Retrieve objects using a qualifier and sort orderings.
     *
     * @param context The editing context to use
     * @param qualifier The qualifier to use
     * @param sortOrderings The sort orderings to use
     *
     * @return an NSArray of the entities retrieved
     */
    public static NSArray<ExternalOutcome> objectsMatchingQualifier(
        EOEditingContext context,
        EOQualifier qualifier,
        NSArray<EOSortOrdering> sortOrderings)
    {
        EOFetchSpecification fspec = new EOFetchSpecification(
            ENTITY_NAME, qualifier, sortOrderings);
        fspec.setUsesDistinct(true);
        return objectsWithFetchSpecification(context, fspec);
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the first object that matches a qualifier, when
     * sorted with the specified sort orderings.
     *
     * @param context The editing context to use
     * @param qualifier The qualifier to use
     * @param sortOrderings the sort orderings
     *
     * @return the first entity that was retrieved, or null if there was none
     */
    public static ExternalOutcome firstObjectMatchingQualifier(
        EOEditingContext context,
        EOQualifier qualifier,
        NSArray<EOSortOrdering> sortOrderings)
    {
        NSArray<ExternalOutcome> results =
            objectsMatchingQualifier(context, qualifier, sortOrderings);
        return (results.size() > 0)
            ? results.get(0)
            : null;
    }


    // ----------------------------------------------------------
    /**
     * Retrieve a single object using a list of keys and values to match.
     *
     * @param context The editing context to use
     * @param qualifier The qualifier to use
     *
     * @return the single entity that was retrieved
     *
     * @throws EOUtilities.MoreThanOneException
     *     if there is more than one matching object
     */
    public static ExternalOutcome uniqueObjectMatchingQualifier(
        EOEditingContext context,
        EOQualifier qualifier) throws EOUtilities.MoreThanOneException
    {
        NSArray<ExternalOutcome> results =
            objectsMatchingQualifier(context, qualifier);
        if (results.size() > 1)
        {
            throw new EOUtilities.MoreThanOneException(null);
        }
        return (results.size() > 0)
            ? results.get(0)
            : null;
    }


    // ----------------------------------------------------------
    /**
     * Retrieve objects using a list of keys and values to match.
     *
     * @param context The editing context to use
     * @param keysAndValues a list of keys and values to match, alternating
     *     "key", "value", "key", "value"...
     *
     * @return an NSArray of the entities retrieved
     */
    public static NSArray<ExternalOutcome> objectsMatchingValues(
        EOEditingContext context,
        Object... keysAndValues)
    {
        if (keysAndValues.length % 2 != 0)
        {
            throw new IllegalArgumentException("There should a value " +
                "corresponding to every key that was passed.");
        }

        NSMutableDictionary<String, Object> valueDictionary =
            new NSMutableDictionary<String, Object>();

        for (int i = 0; i < keysAndValues.length; i += 2)
        {
            Object key = keysAndValues[i];
            Object value = keysAndValues[i + 1];

            if (!(key instanceof String))
            {
                throw new IllegalArgumentException("Keys should be strings.");
            }

            valueDictionary.setObjectForKey(value, key);
        }

        return objectsMatchingValues(context, valueDictionary);
    }


    // ----------------------------------------------------------
    /**
     * Retrieve objects using a dictionary of keys and values to match.
     *
     * @param context The editing context to use
     * @param keysAndValues a dictionary of keys and values to match
     *
     * @return an NSArray of the entities retrieved
     */
    @SuppressWarnings("unchecked")
    public static NSArray<ExternalOutcome> objectsMatchingValues(
        EOEditingContext context,
        NSDictionary<String, Object> keysAndValues)
    {
        return EOUtilities.objectsMatchingValues(context, ENTITY_NAME,
            keysAndValues);
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the first object that matches a set of keys and values, when
     * sorted with the specified sort orderings.
     *
     * @param context The editing context to use
     * @param sortOrderings the sort orderings
     * @param keysAndValues a list of keys and values to match, alternating
     *     "key", "value", "key", "value"...
     *
     * @return the first entity that was retrieved, or null if there was none
     */
    public static ExternalOutcome firstObjectMatchingValues(
        EOEditingContext context,
        NSArray<EOSortOrdering> sortOrderings,
        Object... keysAndValues)
    {
        if (keysAndValues.length % 2 != 0)
        {
            throw new IllegalArgumentException("There should a value " +
                "corresponding to every key that was passed.");
        }

        NSMutableDictionary<String, Object> valueDictionary =
            new NSMutableDictionary<String, Object>();

        for (int i = 0; i < keysAndValues.length; i += 2)
        {
            Object key = keysAndValues[i];
            Object value = keysAndValues[i + 1];

            if (!(key instanceof String))
            {
                throw new IllegalArgumentException("Keys should be strings.");
            }

            valueDictionary.setObjectForKey(value, key);
        }

        return firstObjectMatchingValues(
            context, sortOrderings, valueDictionary);
    }


    // ----------------------------------------------------------
    /**
     * Retrieves the first object that matches a set of keys and values, when
     * sorted with the specified sort orderings.
     *
     * @param context The editing context to use
     * @param sortOrderings the sort orderings
     * @param keysAndValues a dictionary of keys and values to match
     *
     * @return the first entity that was retrieved, or null if there was none
     */
    public static ExternalOutcome firstObjectMatchingValues(
        EOEditingContext context,
        NSArray<EOSortOrdering> sortOrderings,
        NSDictionary<String, Object> keysAndValues)
    {
        EOFetchSpecification fspec = new EOFetchSpecification(
            ENTITY_NAME,
            EOQualifier.qualifierToMatchAllValues(keysAndValues),
            sortOrderings);
        fspec.setFetchLimit(1);

        NSArray<ExternalOutcome> result =
            objectsWithFetchSpecification( context, fspec );

        if ( result.count() == 0 )
        {
            return null;
        }
        else
        {
            return result.objectAtIndex(0);
        }
    }


    // ----------------------------------------------------------
    /**
     * Retrieve a single object using a list of keys and values to match.
     *
     * @param context The editing context to use
     * @param keysAndValues a list of keys and values to match, alternating
     *     "key", "value", "key", "value"...
     *
     * @return the single entity that was retrieved, or null if there was none
     *
     * @throws EOUtilities.MoreThanOneException
     *     if there is more than one matching object
     */
    public static ExternalOutcome uniqueObjectMatchingValues(
        EOEditingContext context,
        Object... keysAndValues) throws EOUtilities.MoreThanOneException
    {
        if (keysAndValues.length % 2 != 0)
        {
            throw new IllegalArgumentException("There should a value " +
                "corresponding to every key that was passed.");
        }

        NSMutableDictionary<String, Object> valueDictionary =
            new NSMutableDictionary<String, Object>();

        for (int i = 0; i < keysAndValues.length; i += 2)
        {
            Object key = keysAndValues[i];
            Object value = keysAndValues[i + 1];

            if (!(key instanceof String))
            {
                throw new IllegalArgumentException("Keys should be strings.");
            }

            valueDictionary.setObjectForKey(value, key);
        }

        return uniqueObjectMatchingValues(context, valueDictionary);
    }


    // ----------------------------------------------------------
    /**
     * Retrieve an object using a dictionary of keys and values to match.
     *
     * @param context The editing context to use
     * @param keysAndValues a dictionary of keys and values to match
     *
     * @return the single entity that was retrieved, or null if there was none
     *
     * @throws EOUtilities.MoreThanOneException
     *     if there is more than one matching object
     */
    public static ExternalOutcome uniqueObjectMatchingValues(
        EOEditingContext context,
        NSDictionary<String, Object> keysAndValues)
        throws EOUtilities.MoreThanOneException
    {
        try
        {
            return (ExternalOutcome)EOUtilities.objectMatchingValues(
                context, ENTITY_NAME, keysAndValues);
        }
        catch (EOObjectNotAvailableException e)
        {
            return null;
        }
    }


    // ----------------------------------------------------------
    /**
     * Produce a string representation of this object.  This implementation
     * calls UserPresentableDescription(), which uses WebObjects' internal
     * mechanism to print out the visible fields of this object.  Normally,
     * subclasses would override userPresentableDescription() to change
     * the way the object is printed.
     *
     * @return A string representation of the object's value
     */
    public String toString()
    {
        return userPresentableDescription();
    }


    //~ Instance/static variables .............................................

    static Logger log = Logger.getLogger( ExternalOutcome.class );
}
