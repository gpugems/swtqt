/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.browser;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;

/**
 * Instances of this class represent java-side "functions" that
 * are invokable from javascript.  Browser clients define these
 * functions by subclassing <code>BrowserFunction</code> and
 * overriding its <code>function(Object[])</code> method.  This
 * method will be invoked whenever javascript running in the
 * Browser makes a call with the function's name.
 * 
 * <p>
 * Application code must explicitly invoke the
 * <code>BrowserFunction.dispose()</code> method to release the
 * resources managed by each instance when those instances are no
 * longer required.  Since there is usually a correlation between
 * the registering of BrowserFunction(s) in a Browser and the
 * loading of a page in the Browser that is aware of these
 * functions, the <code>LocationListener.changed()</code> listener
 * is often a good place to do this.
 * </p><p>
 * Note that disposing a Browser automatically disposes all
 * BrowserFunctions associated with it.
 * </p>
 * 
 * @see #dispose()
 * @see #function(Object[])
 * @see org.eclipse.swt.browser.LocationListener#changed(LocationEvent)
 * 
 * @since 3.5
 */
public class BrowserFunction {
	Browser browser;
	String name;
	String functionString;
	int index;
	boolean isEvaluate;

/**
 * Constructs a new instance of this class, which will be invokable
 * by javascript running in the specified Browser.
 * <p>
 * You must dispose the BrowserFunction when it is no longer required.
 * A common place to do this is in a <code>LocationListener.changed()</code>
 * listener.
 * </p>
 * @param browser the browser whose javascript can invoke this function
 * @param name the name that javascript will use to invoke this function
 *  
 * @exception IllegalArgumentException <ul>
 *    <li>ERROR_NULL_ARGUMENT - if the browser is null</li>
 *    <li>ERROR_NULL_ARGUMENT - if the name is null</li>
 * </ul>
 * 
 * @exception SWTException <ul>
 *    <li>ERROR_WIDGET_DISPOSED - if the browser has been disposed</li>
 *    <li>ERROR_THREAD_INVALID_ACCESS - if not called from the thread that created the receiver</li>
 * </ul>
 * 
 * @see #dispose()
 * @see org.eclipse.swt.browser.LocationListener#changed(LocationEvent)
 */
public BrowserFunction (Browser browser, String name) {
	this (browser, name, true);
}

BrowserFunction (Browser browser, String name, boolean create) {
	super ();
	if (browser == null) SWT.error (SWT.ERROR_NULL_ARGUMENT);
	if (name == null) SWT.error (SWT.ERROR_NULL_ARGUMENT);
	if (browser.isDisposed ()) SWT.error (SWT.ERROR_WIDGET_DISPOSED);
	browser.checkWidget ();
	this.browser = browser;
	this.name = name;
	if (create) browser.webBrowser.createFunction (this);
}

/**
 * Disposes of the resources associated with this BrowserFunction.
 * Applications must dispose of all BrowserFunctions that they create.
 * </p><p>
 * Note that disposing a Browser automatically disposes all
 * BrowserFunctions associated with it.
 * </p>
 */
public void dispose () {
	dispose (true);
}

void dispose (boolean remove) {
	if (index < 0) return;
	if (remove) browser.webBrowser.destroyFunction (this);
	browser = null;
	name = functionString = null;
	index = -1;
}

/**
 * Subclasses should override this method.  This method is invoked when
 * the receiver's function is called from javascript.  If all of the
 * arguments that are passed to the javascript function call are of
 * supported types then this method is invoked with the argument values
 * converted as follows:
 * 
 * javascript null or undefined -> <code>null</code>
 * javascript number -> <code>java.lang.Double</code>
 * javascript string -> <code>java.lang.String</code>
 * javascript boolean -> <code>java.lang.Boolean</code>
 * javascript array whose elements are all of supported types -> <code>java.lang.Object[]</code>
 *
 * If any of the Javascript arguments are of unsupported types then the
 * function invocation will fail and this method will not be called.
 * 
 * This method must return a value with one of these supported types to
 * the javascript caller (note that any subclass of <code>java.lang.Number</code>
 * will be successfully converted to a javascript number).
 * 
 * @param arguments the javascript arguments converted to java equivalents 
 * @return the value to return to the javascript caller
 * 
 * @exception SWTException <ul>
 *    <li>ERROR_THREAD_INVALID_ACCESS when called from the wrong thread</li>
 *    <li>ERROR_FUNCTION_DISPOSED when the BrowserFunction has been disposed</li>
 * </ul>
 */
public Object function (Object[] arguments) {
	if (index < 0) SWT.error (SWT.ERROR_FUNCTION_DISPOSED);
	browser.checkWidget ();
	return null;
}

/**
 * Returns the Browser whose pages can invoke this BrowserFunction.
 *
 * @return the Browser associated with this BrowserFunction
 * 
 * @exception SWTException <ul>
 *    <li>ERROR_THREAD_INVALID_ACCESS when called from the wrong thread</li>
 *    <li>ERROR_FUNCTION_DISPOSED when the BrowserFunction has been disposed</li>
 * </ul>
 */
public Browser getBrowser () {
	if (index < 0) SWT.error (SWT.ERROR_FUNCTION_DISPOSED);
	browser.checkWidget ();
	return browser;
}

/**
 * Returns the name that javascript can use to invoke this BrowserFunction.
 * 
 * @return the BrowserFunction's name
 * 
 * @exception SWTException <ul>
 *    <li>ERROR_THREAD_INVALID_ACCESS when called from the wrong thread</li>
 *    <li>ERROR_FUNCTION_DISPOSED when the BrowserFunction has been disposed</li>
 * </ul>
 */
public String getName () {
	if (index < 0) SWT.error (SWT.ERROR_FUNCTION_DISPOSED);
	browser.checkWidget ();
	return name;
}

/**
 * Returns <code>true</code> if this BrowserFunction has been disposed
 * and <code>false</code> otherwise.
 * <p>
 * This method gets the dispose state for the BrowserFunction.
 * When a BrowserFunction has been disposed it is an error to
 * invoke any of its methods.
 * </p><p>
 * Note that disposing a Browser automatically disposes all
 * BrowserFunctions associated with it.
 * </p>
 * @return <code>true</code> if this BrowserFunction has been disposed
 * and <code>false</code> otherwise
 */
public boolean isDisposed () {
	return index < 0;
}
}
