/*
* Created on Jul 19, 2004
*
* The Open SLEE Project
*
* The source code contained in this file is in in the public domain.          
* It can be used in any project, or product without prior permission, 	      
* license or royalty payments. There is no claim of correctness and
* NO WARRANTY OF ANY KIND provided with this code.
*/
package org.mobicents.slee.container;

import javax.slee.Address;
import javax.slee.EventTypeID;

import org.mobicents.slee.container.component.SbbEventEntry;
import org.mobicents.slee.runtime.activity.ActivityContextHandle;

/**
 * 
 * Implements the InitialEventSelector interface
 * 
 * @author F.Moggia
 * @author E. Martins
 * 
 * 
 */
public class InitialEventSelectorImpl implements javax.slee.InitialEventSelector{
    
	private EventTypeID eventTypeID;
    private String eventName;
    private Object event;
    private ActivityContextHandle activityContextHandle;
    private Address address;
    private String customName;

    int[] select;
    private boolean isSelectMethod = false;
    private boolean isActivityContextSelected= false;
    private boolean isAddressProfileSelected= false;
    private boolean isAddressSelected= false;
    private boolean isEventSelected= false;
    private boolean isEventTypeSelected= false;
    
    private boolean isInitialEvent= false;
    
    private String selectMethodName;
 
    public InitialEventSelectorImpl(EventTypeID type, Object event, ActivityContextHandle activityContextHandle,  int[] select, String methodName, Address address) {
        eventTypeID = type;
        this.event = event;
        this.address = address;
        this.activityContextHandle = activityContextHandle;
        
        for(int i=0; i<select.length;i++){
            switch(select[i]){ 
            	case SbbEventEntry.ACTIVITY_CONTEXT_INITIAL_EVENT_SELECT: this.isActivityContextSelected = true;break;
            	case SbbEventEntry.ADDRESS_INITIAL_EVENT_SELECT:this.isAddressSelected=true;break;
            	case SbbEventEntry.ADDRESS_PROFILE_INITIAL_EVENT_SELECT:this.isAddressProfileSelected=true;break;
            	case SbbEventEntry.EVENT_INITIAL_EVENT_SELECT:this.isEventSelected=true;break;
            	case SbbEventEntry.EVENT_TYPE_INITIAL_EVENT_SELECT:this.isEventTypeSelected=true;break;
            }
        }
        
        if (methodName == null){
            isSelectMethod = false;
        } else {
            isSelectMethod = true;
            selectMethodName = methodName;
        }
    }
    
    public String toString() {
        return "InitialEventSelector = {\n eventTypeID " + eventTypeID 
        	+ " eventName " + eventName
        	+ " event " + event 
        	+ " acHandle " + activityContextHandle
        	+ " address " + address
        	+ "\n activityContextSelected = "  + isActivityContextSelected
        	+ "\n isAddressSelected " + isAddressSelected
        	+ "\n isAddressProfileSelected " + isAddressProfileSelected
        	+ "\n isEventSelected " + isEventSelected 
        	+ "\n customName " + customName
        	+ "\n selectMethodName " + selectMethodName
        	+ "\n}";
    }
    
    /**
     * @return Returns the isActivityContextSelected.
     */
    public boolean isActivityContextSelected() {
        return this.isActivityContextSelected;
    }
    /**
     * @return Returns the isAddressProfileSelected.
     */
    public boolean isAddressProfileSelected() {
        return this.isAddressProfileSelected;
    }
    /**
     * @return Returns the isAddressSelected.
     */
    public boolean isAddressSelected() {
        return this.isAddressSelected;
    }
    /**
     * @return Returns the isEventTypeSelected.
     */
    public boolean isEventTypeSelected() {
        return this.isEventTypeSelected;
    }
    /**
     * @return Returns the eventType.
     */
    public EventTypeID getEventTypeID() {
        return eventTypeID;
    }
    /**
     * @param eventType The eventType to set.
     */
    public void setEventType(EventTypeID eventTypeID) {
        this.eventTypeID = eventTypeID;
    }
    /**
     * @return Returns the isEventSelected.
     */
    public boolean isEventSelected() {
        return this.isEventSelected;
    }
    /**
     * @param isEventSelected The isEventSelected to set.
     */
    
    /**
     * @param isAddressProfileSelected The isAddressProfileSelected to set.
     */
    public void setAddressProfileSelected(boolean isAddressProfileSelected) {
        this.isAddressProfileSelected = isAddressProfileSelected;
    }
    /**
     * @param isAddressSelected The isAddressSelected to set.
     */
    public void setAddressSelected(boolean isAddressSelected) {
        this.isAddressSelected = isAddressSelected;
    }
    /**
     * @param isEventTypeSelected The isEventTypeSelected to set.
     */
    public void setEventTypeSelected(boolean isEventTypeSelected) {
        this.isEventTypeSelected = isEventTypeSelected;
    }
    /**
     * @return Returns the isSelectMethod.
     */
    public boolean isSelectMethod() {
        return isSelectMethod;
    }
    /**
     * @param isSelectMethod The isSelectMethod to set.
     */
    public void setSelectMethod(boolean isSelectMethod) {
        this.isSelectMethod = isSelectMethod;
    }
    /**
     * @return Returns the selectMethodName.
     */
    public String getSelectMethodName() {
        return selectMethodName;
    }
    /**
     * @param selectMethodName The selectMethodName to set.
     */
    public void setSelectMethodName(String selectMethodName) {
        this.selectMethodName = selectMethodName;
    }
    /* (non-Javadoc)
     * @see javax.slee.InitialEventSelector#getEventName()
     */
    public String getEventName() {
        return eventName;
    }
    /* (non-Javadoc)
     * @see javax.slee.InitialEventSelector#getEvent()
     */
    public Object getEvent() {
        return event;
    }
    /* (non-Javadoc)
     * @see javax.slee.InitialEventSelector#getActivity()
     */
    public Object getActivity() {
        return activityContextHandle.getActivity();
    }
    /* (non-Javadoc)
     * @see javax.slee.InitialEventSelector#getAddress()
     */
    public Address getAddress() {
        
        return address;
    }
    /* (non-Javadoc)
     * @see javax.slee.InitialEventSelector#setAddress(javax.slee.Address)
     */
    public void setAddress(Address address) {
        
        this.address = address;
    }
    /* (non-Javadoc)
     * @see javax.slee.InitialEventSelector#getCustomName()
     */
    public String getCustomName() {
        
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }
    
    public void setActivityContextSelected(boolean isActivityContextSelected) {
        this.isActivityContextSelected = isActivityContextSelected;
    }
    
    public void setEventSelected(boolean isEventSelected) {
        this.isEventSelected = isEventSelected;
    }
    
    public boolean isInitialEvent() {
        return isInitialEvent;
    }
    
    public void setInitialEvent(boolean isInitialEvent) {
        this.isInitialEvent = isInitialEvent;
    }
}
