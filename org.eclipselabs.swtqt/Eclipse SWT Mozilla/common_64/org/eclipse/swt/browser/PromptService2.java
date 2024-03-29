/*******************************************************************************
 * Copyright (c) 2003, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.swt.browser;

import org.eclipse.swt.*;
import org.eclipse.swt.internal.*;
import org.eclipse.swt.internal.mozilla.*;
import org.eclipse.swt.widgets.*;

class PromptService2 {
	XPCOMObject supports;
	XPCOMObject promptService;
	XPCOMObject promptService2;
	int refCount = 0;

	static final String[] certErrorCodes = new String[] {
		"ssl_error_bad_cert_domain",
		"sec_error_ca_cert_invalid",
		"sec_error_expired_certificate",
		"sec_error_expired_issuer_certificate",
		"sec_error_inadequate_key_usage",
		"sec_error_unknown_issuer",
		"sec_error_untrusted_cert",
		"sec_error_untrusted_issuer",
	};	//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$

PromptService2 () {
	createCOMInterfaces ();
}

int AddRef () {
	refCount++;
	return refCount;
}

void createCOMInterfaces () {
	/* Create each of the interfaces that this object implements */
	supports = new XPCOMObject (new int[] {2, 0, 0}) {
		public long /*int*/ method0 (long /*int*/[] args) {return QueryInterface (args[0], args[1]);}
		public long /*int*/ method1 (long /*int*/[] args) {return AddRef ();}
		public long /*int*/ method2 (long /*int*/[] args) {return Release ();}
	};
	
	promptService = new XPCOMObject (new int[] {2, 0, 0, 3, 5, 4, 6, 10, 7, 8, 7, 7}) {
		public long /*int*/ method0 (long /*int*/[] args) {return QueryInterface (args[0], args[1]);}
		public long /*int*/ method1 (long /*int*/[] args) {return AddRef ();}
		public long /*int*/ method2 (long /*int*/[] args) {return Release ();}
		public long /*int*/ method3 (long /*int*/[] args) {return Alert (args[0], args[1], args[2]);}
		public long /*int*/ method4 (long /*int*/[] args) {return AlertCheck (args[0], args[1], args[2], args[3], args[4]);}
		public long /*int*/ method5 (long /*int*/[] args) {return Confirm (args[0], args[1], args[2], args[3]);}
		public long /*int*/ method6 (long /*int*/[] args) {return ConfirmCheck (args[0], args[1], args[2], args[3], args[4], args[5]);}
		public long /*int*/ method7 (long /*int*/[] args) {return ConfirmEx (args[0], args[1], args[2], (int)/*64*/args[3], args[4], args[5], args[6], args[7], args[8], args[9]);}
		public long /*int*/ method8 (long /*int*/[] args) {return Prompt (args[0], args[1], args[2], args[3], args[4], args[5], args[6]);}
		public long /*int*/ method9 (long /*int*/[] args) {return PromptUsernameAndPassword (args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7]);}
		public long /*int*/ method10 (long /*int*/[] args) {return PromptPassword (args[0], args[1], args[2], args[3], args[4], args[5], args[6]);}
		public long /*int*/ method11 (long /*int*/[] args) {return Select (args[0], args[1], args[2], (int)/*64*/args[3], args[4], args[5], args[6]);}
	};
	
	promptService2 = new XPCOMObject (new int[] {2, 0, 0, 3, 5, 4, 6, 10, 7, 8, 7, 7, 7, 9}) {
		public long /*int*/ method0 (long /*int*/[] args) {return QueryInterface (args[0], args[1]);}
		public long /*int*/ method1 (long /*int*/[] args) {return AddRef ();}
		public long /*int*/ method2 (long /*int*/[] args) {return Release ();}
		public long /*int*/ method3 (long /*int*/[] args) {return Alert (args[0], args[1], args[2]);}
		public long /*int*/ method4 (long /*int*/[] args) {return AlertCheck (args[0], args[1], args[2], args[3], args[4]);}
		public long /*int*/ method5 (long /*int*/[] args) {return Confirm (args[0], args[1], args[2], args[3]);}
		public long /*int*/ method6 (long /*int*/[] args) {return ConfirmCheck (args[0], args[1], args[2], args[3], args[4], args[5]);}
		public long /*int*/ method7 (long /*int*/[] args) {return ConfirmEx (args[0], args[1], args[2], (int)/*64*/args[3], args[4], args[5], args[6], args[7], args[8], args[9]);}
		public long /*int*/ method8 (long /*int*/[] args) {return Prompt (args[0], args[1], args[2], args[3], args[4], args[5], args[6]);}
		public long /*int*/ method9 (long /*int*/[] args) {return PromptUsernameAndPassword (args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7]);}
		public long /*int*/ method10 (long /*int*/[] args) {return PromptPassword (args[0], args[1], args[2], args[3], args[4], args[5], args[6]);}
		public long /*int*/ method11 (long /*int*/[] args) {return Select (args[0], args[1], args[2], (int)/*64*/args[3], args[4], args[5], args[6]);}
		public long /*int*/ method12 (long /*int*/[] args) {return PromptAuth (args[0], args[1], (int)/*64*/args[2], args[3], args[4], args[5], args[6]);}
		public long /*int*/ method13 (long /*int*/[] args) {return AsyncPromptAuth (args[0], args[1], args[2], args[3], (int)/*64*/args[4], args[5], args[6], args[7], args[8]);}
	};
}

void disposeCOMInterfaces () {
	if (supports != null) {
		supports.dispose ();
		supports = null;
	}	
	if (promptService != null) {
		promptService.dispose ();
		promptService = null;	
	}
	if (promptService2 != null) {
		promptService2.dispose ();
		promptService2 = null;	
	}
}

long /*int*/ getAddress () {
	return promptService2.getAddress ();
}

int QueryInterface (long /*int*/ riid, long /*int*/ ppvObject) {
	if (riid == 0 || ppvObject == 0) return XPCOM.NS_ERROR_NO_INTERFACE;
	nsID guid = new nsID ();
	XPCOM.memmove (guid, riid, nsID.sizeof);
	
	if (guid.Equals (nsISupports.NS_ISUPPORTS_IID)) {
		XPCOM.memmove (ppvObject, new long /*int*/[] {supports.getAddress ()}, C.PTR_SIZEOF);
		AddRef ();
		return XPCOM.NS_OK;
	}
	if (guid.Equals (nsIPromptService.NS_IPROMPTSERVICE_IID)) {
		XPCOM.memmove (ppvObject, new long /*int*/[] {promptService.getAddress ()}, C.PTR_SIZEOF);
		AddRef ();
		return XPCOM.NS_OK;
	}
	if (guid.Equals (nsIPromptService2.NS_IPROMPTSERVICE2_IID)) {
		XPCOM.memmove (ppvObject, new long /*int*/[] {promptService2.getAddress ()}, C.PTR_SIZEOF);
		AddRef ();
		return XPCOM.NS_OK;
	}

	XPCOM.memmove (ppvObject, new long /*int*/[] {0}, C.PTR_SIZEOF);
	return XPCOM.NS_ERROR_NO_INTERFACE;
}
        	
int Release () {
	refCount--;
	if (refCount == 0) disposeCOMInterfaces ();
	return refCount;
}

Browser getBrowser (long /*int*/ aDOMWindow) {
	if (aDOMWindow == 0) return null;
	nsIDOMWindow window = new nsIDOMWindow (aDOMWindow);
	return Mozilla.findBrowser (window);
}

String getLabel (int buttonFlag, int index, long /*int*/ buttonTitle) {
	String label = null;
	int flag = (buttonFlag & (0xff * index)) / index;
	switch (flag) {
		case nsIPromptService.BUTTON_TITLE_CANCEL : label = SWT.getMessage ("SWT_Cancel"); break; //$NON-NLS-1$
		case nsIPromptService.BUTTON_TITLE_NO : label = SWT.getMessage ("SWT_No"); break; //$NON-NLS-1$
		case nsIPromptService.BUTTON_TITLE_OK : label = SWT.getMessage ("SWT_OK"); break; //$NON-NLS-1$
		case nsIPromptService.BUTTON_TITLE_SAVE : label = SWT.getMessage ("SWT_Save"); break; //$NON-NLS-1$
		case nsIPromptService.BUTTON_TITLE_YES : label = SWT.getMessage ("SWT_Yes"); break; //$NON-NLS-1$
		case nsIPromptService.BUTTON_TITLE_IS_STRING : {
			int length = XPCOM.strlen_PRUnichar (buttonTitle);
			char[] dest = new char[length];
			XPCOM.memmove (dest, buttonTitle, length * 2);
			label = new String (dest);
		}
	}
	return label;
}

/* nsIPromptService */

int Alert (long /*int*/ aParent, long /*int*/ aDialogTitle, long /*int*/ aText) {
	final Browser browser = getBrowser (aParent);
	
	int length = XPCOM.strlen_PRUnichar (aDialogTitle);
	char[] dest = new char[length];
	XPCOM.memmove (dest, aDialogTitle, length * 2);
	String titleLabel = new String (dest);

	length = XPCOM.strlen_PRUnichar (aText);
	dest = new char[length];
	XPCOM.memmove (dest, aText, length * 2);
	String textLabel = new String (dest);

	/*
	* If mozilla is showing its errors with dialogs (as opposed to pages) then the only
	* opportunity to detect that a page has an invalid certificate, without receiving
	* all notification callbacks on the channel, is to detect the displaying of an alert
	* whose message contains an internal cert error code.  If a such a message is
	* detected then instead of showing it, re-navigate to the page with the invalid
	* certificate so that the browser's nsIBadCertListener2 will be invoked.
	*/
	if (browser != null) {
		for (int i = 0; i < certErrorCodes.length; i++) {
			if (textLabel.indexOf (certErrorCodes[i]) != -1) {
				Mozilla mozilla = (Mozilla)browser.webBrowser;
				mozilla.isRetrievingBadCert = true;
				browser.setUrl (mozilla.lastNavigateURL);
				return XPCOM.NS_OK;
			}
		}
	}

	Shell shell = browser == null ? new Shell () : browser.getShell (); 
	MessageBox messageBox = new MessageBox (shell, SWT.OK | SWT.ICON_WARNING);
	messageBox.setText (titleLabel);
	messageBox.setMessage (textLabel);
	messageBox.open ();
	return XPCOM.NS_OK;
}

int AlertCheck (long /*int*/ aParent, long /*int*/ aDialogTitle, long /*int*/ aText, long /*int*/ aCheckMsg, long /*int*/ aCheckState) {
	Browser browser = getBrowser (aParent);
	
	int length = XPCOM.strlen_PRUnichar (aDialogTitle);
	char[] dest = new char[length];
	XPCOM.memmove (dest, aDialogTitle, length * 2);
	String titleLabel = new String (dest);

	length = XPCOM.strlen_PRUnichar (aText);
	dest = new char[length];
	XPCOM.memmove (dest, aText, length * 2);
	String textLabel = new String (dest);

	length = XPCOM.strlen_PRUnichar (aCheckMsg);
	dest = new char[length];
	XPCOM.memmove (dest, aCheckMsg, length * 2);
	String checkLabel = new String (dest);

	Shell shell = browser == null ? new Shell () : browser.getShell ();
	PromptDialog dialog = new PromptDialog (shell);
	int[] check = new int[1];
	if (aCheckState != 0) XPCOM.memmove (check, aCheckState, 4); /* PRBool */
	dialog.alertCheck (titleLabel, textLabel, checkLabel, check);
	if (aCheckState != 0) XPCOM.memmove (aCheckState, check, 4); /* PRBool */
	return XPCOM.NS_OK;
}

int AsyncPromptAuth(long /*int*/ aParent, long /*int*/ aChannel, long /*int*/ aCallback, long /*int*/ aContext, int level, long /*int*/ authInfo, long /*int*/ checkboxLabel, long /*int*/ checkValue, long /*int*/ _retval) {
	return XPCOM.NS_ERROR_NOT_IMPLEMENTED;
}

int Confirm (long /*int*/ aParent, long /*int*/ aDialogTitle, long /*int*/ aText, long /*int*/ _retval) {
	Browser browser = getBrowser (aParent);
	
	int length = XPCOM.strlen_PRUnichar (aDialogTitle);
	char[] dest = new char[length];
	XPCOM.memmove (dest, aDialogTitle, length * 2);
	String titleLabel = new String (dest);

	length = XPCOM.strlen_PRUnichar (aText);
	dest = new char[length];
	XPCOM.memmove (dest, aText, length * 2);
	String textLabel = new String (dest);

	Shell shell = browser == null ? new Shell () : browser.getShell ();
	MessageBox messageBox = new MessageBox (shell, SWT.OK | SWT.CANCEL | SWT.ICON_QUESTION);
	messageBox.setText (titleLabel);
	messageBox.setMessage (textLabel);
	int id = messageBox.open ();
	int[] result = {id == SWT.OK ? 1 : 0};
	XPCOM.memmove (_retval, result, 4);
	return XPCOM.NS_OK;
}

int ConfirmCheck (long /*int*/ aParent, long /*int*/ aDialogTitle, long /*int*/ aText, long /*int*/ aCheckMsg, long /*int*/ aCheckState, long /*int*/ _retval) {
	return XPCOM.NS_ERROR_NOT_IMPLEMENTED;
}

int ConfirmEx (long /*int*/ aParent, long /*int*/ aDialogTitle, long /*int*/ aText, int aButtonFlags, long /*int*/ aButton0Title, long /*int*/ aButton1Title, long /*int*/ aButton2Title, long /*int*/ aCheckMsg, long /*int*/ aCheckState, long /*int*/ _retval) {
	Browser browser = getBrowser (aParent);
	
	int length = XPCOM.strlen_PRUnichar (aDialogTitle);
	char[] dest = new char[length];
	XPCOM.memmove (dest, aDialogTitle, length * 2);
	String titleLabel = new String (dest);

	length = XPCOM.strlen_PRUnichar (aText);
	dest = new char[length];
	XPCOM.memmove (dest, aText, length * 2);
	String textLabel = new String (dest);
	
	String checkLabel = null;
	if (aCheckMsg != 0) {
		length = XPCOM.strlen_PRUnichar (aCheckMsg);
		dest = new char[length];
		XPCOM.memmove (dest, aCheckMsg, length * 2);
		checkLabel = new String (dest);
	}
	
	String button0Label = getLabel (aButtonFlags, nsIPromptService.BUTTON_POS_0, aButton0Title);
	String button1Label = getLabel (aButtonFlags, nsIPromptService.BUTTON_POS_1, aButton1Title);
	String button2Label = getLabel (aButtonFlags, nsIPromptService.BUTTON_POS_2, aButton2Title);
	
	int defaultIndex = 0;
	if ((aButtonFlags & nsIPromptService.BUTTON_POS_1_DEFAULT) != 0) {
		defaultIndex = 1;
	} else if ((aButtonFlags & nsIPromptService.BUTTON_POS_2_DEFAULT) != 0) {
		defaultIndex = 2;
	}
	
	Shell shell = browser == null ? new Shell () : browser.getShell ();
	PromptDialog dialog = new PromptDialog (shell);
	int[] check = new int[1], result = new int[1];
	if (aCheckState != 0) XPCOM.memmove (check, aCheckState, 4);
	dialog.confirmEx (titleLabel, textLabel, checkLabel, button0Label, button1Label, button2Label, defaultIndex, check, result);
	if (aCheckState != 0) XPCOM.memmove (aCheckState, check, 4);
	XPCOM.memmove (_retval, result, 4);
	return XPCOM.NS_OK;
}

int Prompt (long /*int*/ aParent, long /*int*/ aDialogTitle, long /*int*/ aText, long /*int*/ aValue, long /*int*/ aCheckMsg, long /*int*/ aCheckState, long /*int*/ _retval) {
	Browser browser = getBrowser (aParent);
	String titleLabel = null, textLabel, checkLabel = null;
	String[] valueLabel = new String[1];
	char[] dest;
	int length;
	if (aDialogTitle != 0) {
		length = XPCOM.strlen_PRUnichar (aDialogTitle);
		dest = new char[length];
		XPCOM.memmove (dest, aDialogTitle, length * 2);
		titleLabel = new String (dest);
	}
	
	length = XPCOM.strlen_PRUnichar (aText);
	dest = new char[length];
	XPCOM.memmove (dest, aText, length * 2);
	textLabel = new String (dest);
	
	long /*int*/[] valueAddr = new long /*int*/[1];
	XPCOM.memmove (valueAddr, aValue, C.PTR_SIZEOF);
	if (valueAddr[0] != 0) {
		length = XPCOM.strlen_PRUnichar (valueAddr[0]);
		dest = new char[length];
		XPCOM.memmove (dest, valueAddr[0], length * 2);
		valueLabel[0] = new String (dest);		
	}
	
	if (aCheckMsg != 0) {
		length = XPCOM.strlen_PRUnichar (aCheckMsg);
		if (length > 0) {
			dest = new char[length];
			XPCOM.memmove (dest, aCheckMsg, length * 2);
			checkLabel = new String (dest);
		}
	}

	Shell shell = browser == null ? new Shell () : browser.getShell ();
	PromptDialog dialog = new PromptDialog (shell);
	int[] check = new int[1], result = new int[1];
	if (aCheckState != 0) XPCOM.memmove (check, aCheckState, 4);
	dialog.prompt (titleLabel, textLabel, checkLabel, valueLabel, check, result);

	XPCOM.memmove (_retval, result, 4);
	if (result[0] == 1) {
		/* 
		* User selected OK. User name and password are returned as PRUnichar values. Any default
		* value that we override must be freed using the nsIMemory service.
		*/
		if (valueLabel[0] != null) {
			long /*int*/[] result2 = new long /*int*/[1];
			int rc = XPCOM.NS_GetServiceManager (result2);
			if (rc != XPCOM.NS_OK) SWT.error (rc);
			if (result2[0] == 0) SWT.error (XPCOM.NS_NOINTERFACE);

			nsIServiceManager serviceManager = new nsIServiceManager (result2[0]);
			result2[0] = 0;
			byte[] aContractID = MozillaDelegate.wcsToMbcs (null, XPCOM.NS_MEMORY_CONTRACTID, true);
			rc = serviceManager.GetServiceByContractID (aContractID, nsIMemory.NS_IMEMORY_IID, result2);
			if (rc != XPCOM.NS_OK) SWT.error (rc);
			if (result2[0] == 0) SWT.error (XPCOM.NS_NOINTERFACE);		
			serviceManager.Release ();

			nsIMemory memory = new nsIMemory (result2[0]);
			result2[0] = 0;

			int cnt = valueLabel[0].length ();
			char[] buffer = new char[cnt + 1];
			valueLabel[0].getChars (0, cnt, buffer, 0);
			int size = buffer.length * 2;
			long /*int*/ ptr = memory.Alloc (size);
			XPCOM.memmove (ptr, buffer, size);
			XPCOM.memmove (aValue, new long /*int*/[] {ptr}, C.PTR_SIZEOF);

			if (valueAddr[0] != 0) {
				memory.Free (valueAddr[0]);
			}
			memory.Release ();
		}
	}
	if (aCheckState != 0) XPCOM.memmove (aCheckState, check, 4);
	return XPCOM.NS_OK;
}

int PromptAuth(long /*int*/ aParent, long /*int*/ aChannel, int level, long /*int*/ authInfo, long /*int*/ checkboxLabel, long /*int*/ checkboxValue, long /*int*/ _retval) {
	nsIAuthInformation auth = new nsIAuthInformation (authInfo);

	Browser browser = getBrowser (aParent);
	if (browser != null) {
		Mozilla mozilla = (Mozilla)browser.webBrowser;
		/*
		 * Do not invoke the listeners if this challenge has been failed too many
		 * times because a listener is likely giving incorrect credentials repeatedly
		 * and will do so indefinitely.
		 */
		if (mozilla.authCount++ < 3) {
			for (int i = 0; i < mozilla.authenticationListeners.length; i++) {
				AuthenticationEvent event = new AuthenticationEvent (browser);
				event.location = mozilla.lastNavigateURL;
				mozilla.authenticationListeners[i].authenticate (event);
				if (!event.doit) {
					XPCOM.memmove (_retval, new int[] {0}, 4);	/* PRBool */
					return XPCOM.NS_OK;
				}
				if (event.user != null && event.password != null) {
					nsEmbedString string = new nsEmbedString (event.user);
					int rc = auth.SetUsername (string.getAddress ());
					if (rc != XPCOM.NS_OK) SWT.error (rc);
					string.dispose ();
					string = new nsEmbedString (event.password);
					rc = auth.SetPassword (string.getAddress ());
					if (rc != XPCOM.NS_OK) SWT.error (rc);
					string.dispose ();
					XPCOM.memmove (_retval, new int[] {1}, 4);	/* PRBool */
					return XPCOM.NS_OK;
				}
			}
		}
	}

	/* no listener handled the challenge, so show an authentication dialog */

	String checkLabel = null;
	int[] checkValue = new int[1];
	String[] userLabel = new String[1], passLabel = new String[1];

	String title = SWT.getMessage ("SWT_Authentication_Required"); //$NON-NLS-1$

	if (checkboxLabel != 0 && checkboxValue != 0) {
		int length = XPCOM.strlen_PRUnichar (checkboxLabel);
		char[] dest = new char[length];
		XPCOM.memmove (dest, checkboxLabel, length * 2);
		checkLabel = new String (dest);
		XPCOM.memmove (checkValue, checkboxValue, 4); /* PRBool */
	}

	/* get initial username and password values */

	long /*int*/ ptr = XPCOM.nsEmbedString_new ();
	int rc = auth.GetUsername (ptr);
	if (rc != XPCOM.NS_OK) SWT.error (rc);
	int length = XPCOM.nsEmbedString_Length (ptr);
	long /*int*/ buffer = XPCOM.nsEmbedString_get (ptr);
	char[] chars = new char[length];
	XPCOM.memmove (chars, buffer, length * 2);
	userLabel[0] = new String (chars);
	XPCOM.nsEmbedString_delete (ptr);

	ptr = XPCOM.nsEmbedString_new ();
	rc = auth.GetPassword (ptr);
	if (rc != XPCOM.NS_OK) SWT.error (rc);
	length = XPCOM.nsEmbedString_Length (ptr);
	buffer = XPCOM.nsEmbedString_get (ptr);
	chars = new char[length];
	XPCOM.memmove (chars, buffer, length * 2);
	passLabel[0] = new String (chars);
	XPCOM.nsEmbedString_delete (ptr);

	/* compute the message text */

	ptr = XPCOM.nsEmbedString_new ();
	rc = auth.GetRealm (ptr);
	if (rc != XPCOM.NS_OK) SWT.error (rc);
	length = XPCOM.nsEmbedString_Length (ptr);
	buffer = XPCOM.nsEmbedString_get (ptr);
	chars = new char[length];
	XPCOM.memmove (chars, buffer, length * 2);
	String realm = new String (chars);
	XPCOM.nsEmbedString_delete (ptr);

	nsIChannel channel = new nsIChannel (aChannel);
	long /*int*/[] uri = new long /*int*/[1];
	rc = channel.GetURI (uri);
	if (rc != XPCOM.NS_OK) SWT.error (rc);
	if (uri[0] == 0) Mozilla.error (XPCOM.NS_NOINTERFACE);

	nsIURI nsURI = new nsIURI (uri[0]);
	long /*int*/ host = XPCOM.nsEmbedCString_new ();
	rc = nsURI.GetHost (host);
	if (rc != XPCOM.NS_OK) SWT.error (rc);
	length = XPCOM.nsEmbedCString_Length (host);
	buffer = XPCOM.nsEmbedCString_get (host);
	byte[] bytes = new byte[length];
	XPCOM.memmove (bytes, buffer, length);
	String hostString = new String (bytes);
	XPCOM.nsEmbedCString_delete (host);
	nsURI.Release ();

	String message;
	if (realm.length () > 0 && hostString.length () > 0) {
		message = Compatibility.getMessage ("SWT_Enter_Username_and_Password", new String[] {realm, hostString}); //$NON-NLS-1$
	} else {
		message = ""; //$NON-NLS-1$
	}

	/* open the prompter */
	Shell shell = browser == null ? new Shell () : browser.getShell ();
	PromptDialog dialog = new PromptDialog (shell);
	int[] result = new int[1];
	dialog.promptUsernameAndPassword (title, message, checkLabel, userLabel, passLabel, checkValue, result);

	XPCOM.memmove (_retval, result, 4);	/* PRBool */
	if (result[0] == 1) {	/* User selected OK */
		nsEmbedString string = new nsEmbedString (userLabel[0]);
		rc = auth.SetUsername(string.getAddress ());
		if (rc != XPCOM.NS_OK) SWT.error (rc);
		string.dispose ();
		
		string = new nsEmbedString (passLabel[0]);
		rc = auth.SetPassword(string.getAddress ());
		if (rc != XPCOM.NS_OK) SWT.error (rc);
		string.dispose ();
	}

	if (checkboxValue != 0) XPCOM.memmove (checkboxValue, checkValue, 4); /* PRBool */
	return XPCOM.NS_OK;
}

int PromptUsernameAndPassword (long /*int*/ aParent, long /*int*/ aDialogTitle, long /*int*/ aText, long /*int*/ aUsername, long /*int*/ aPassword, long /*int*/ aCheckMsg, long /*int*/ aCheckState, long /*int*/ _retval) {
	Browser browser = getBrowser (aParent);
	String user = null, password = null;

	if (browser != null) {
		Mozilla mozilla = (Mozilla)browser.webBrowser;
		/*
		 * Do not invoke the listeners if this challenge has been failed too many
		 * times because a listener is likely giving incorrect credentials repeatedly
		 * and will do so indefinitely.
		 */
		if (mozilla.authCount++ < 3) {
			for (int i = 0; i < mozilla.authenticationListeners.length; i++) {
				AuthenticationEvent event = new AuthenticationEvent (browser);
				event.location = mozilla.lastNavigateURL;
				mozilla.authenticationListeners[i].authenticate (event);
				if (!event.doit) {
					XPCOM.memmove (_retval, new int[] {0}, 4);	/* PRBool */
					return XPCOM.NS_OK;
				}
				if (event.user != null && event.password != null) {
					user = event.user;
					password = event.password;
					XPCOM.memmove (_retval, new int[] {1}, 4);	/* PRBool */
					break;
				}
			}
		}
	}

	if (user == null) {
		/* no listener handled the challenge, so show an authentication dialog */

		String titleLabel, textLabel, checkLabel = null;
		String[] userLabel = new String[1], passLabel = new String[1];
		char[] dest;
		int length;
		if (aDialogTitle != 0) {
			length = XPCOM.strlen_PRUnichar (aDialogTitle);
			dest = new char[length];
			XPCOM.memmove (dest, aDialogTitle, length * 2);
			titleLabel = new String (dest);
		} else {
			titleLabel = SWT.getMessage ("SWT_Authentication_Required");	//$NON-NLS-1$
		}
		
		length = XPCOM.strlen_PRUnichar (aText);
		dest = new char[length];
		XPCOM.memmove (dest, aText, length * 2);
		textLabel = new String (dest);

		long /*int*/[] userAddr = new long /*int*/[1];
		XPCOM.memmove (userAddr, aUsername, C.PTR_SIZEOF);
		if (userAddr[0] != 0) {
			length = XPCOM.strlen_PRUnichar (userAddr[0]);
			dest = new char[length];
			XPCOM.memmove (dest, userAddr[0], length * 2);
			userLabel[0] = new String (dest);		
		}

		long /*int*/[] passAddr = new long /*int*/[1];
		XPCOM.memmove (passAddr, aPassword, C.PTR_SIZEOF);
		if (passAddr[0] != 0) {
			length = XPCOM.strlen_PRUnichar (passAddr[0]);
			dest = new char[length];
			XPCOM.memmove (dest, passAddr[0], length * 2);
			passLabel[0] = new String (dest);		
		}
		
		if (aCheckMsg != 0) {
			length = XPCOM.strlen_PRUnichar (aCheckMsg);
			if (length > 0) {
				dest = new char[length];
				XPCOM.memmove (dest, aCheckMsg, length * 2);
				checkLabel = new String (dest);
			}
		}
	
		Shell shell = browser == null ? new Shell () : browser.getShell ();
		PromptDialog dialog = new PromptDialog (shell);
		int[] check = new int[1], result = new int[1];
		if (aCheckState != 0) XPCOM.memmove (check, aCheckState, 4);	/* PRBool */
		dialog.promptUsernameAndPassword (titleLabel, textLabel, checkLabel, userLabel, passLabel, check, result);
	
		XPCOM.memmove (_retval, result, 4);	/* PRBool */
		if (result[0] == 1) {
			/* User selected OK */
			user = userLabel[0];
			password = passLabel[0];
		}
		if (aCheckState != 0) XPCOM.memmove (aCheckState, check, 4); /* PRBool */
	}

	if (user != null) {
		/* 
		* User name and password are returned as PRUnichar values. Any default
		* value that we override must be freed using the nsIMemory service.
		*/
		long /*int*/[] userAddr = new long /*int*/[1];
		XPCOM.memmove (userAddr, aUsername, C.PTR_SIZEOF);
		long /*int*/[] passAddr = new long /*int*/[1];
		XPCOM.memmove (passAddr, aPassword, C.PTR_SIZEOF);

		long /*int*/[] result = new long /*int*/[1];
		int rc = XPCOM.NS_GetServiceManager (result);
		if (rc != XPCOM.NS_OK) SWT.error (rc);
		if (result[0] == 0) SWT.error (XPCOM.NS_NOINTERFACE);

		nsIServiceManager serviceManager = new nsIServiceManager (result[0]);
		result[0] = 0;
		byte[] aContractID = MozillaDelegate.wcsToMbcs (null, XPCOM.NS_MEMORY_CONTRACTID, true);
		rc = serviceManager.GetServiceByContractID (aContractID, nsIMemory.NS_IMEMORY_IID, result);
		if (rc != XPCOM.NS_OK) SWT.error (rc);
		if (result[0] == 0) SWT.error (XPCOM.NS_NOINTERFACE);		
		serviceManager.Release ();

		nsIMemory memory = new nsIMemory (result[0]);
		result[0] = 0;
		if (userAddr[0] != 0) memory.Free (userAddr[0]);
		if (passAddr[0] != 0) memory.Free (passAddr[0]);
		memory.Release ();

		/* write the name and password values */

		int cnt = user.length ();
		char[] buffer = new char[cnt + 1];
		user.getChars (0, cnt, buffer, 0);
		int size = buffer.length * 2;
		long /*int*/ ptr = C.malloc (size);
		XPCOM.memmove (ptr, buffer, size);
		XPCOM.memmove (aUsername, new long /*int*/[] {ptr}, C.PTR_SIZEOF);

		cnt = password.length ();
		buffer = new char[cnt + 1];
		password.getChars (0, cnt, buffer, 0);
		size = buffer.length * 2;
		ptr = C.malloc (size);
		XPCOM.memmove (ptr, buffer, size);
		XPCOM.memmove (aPassword, new long /*int*/[] {ptr}, C.PTR_SIZEOF);
	}

	return XPCOM.NS_OK;
}

int PromptPassword (long /*int*/ aParent, long /*int*/ aDialogTitle, long /*int*/ aText, long /*int*/ aPassword, long /*int*/ aCheckMsg, long /*int*/ aCheckState, long /*int*/ _retval) {
	return XPCOM.NS_ERROR_NOT_IMPLEMENTED;
}

int Select (long /*int*/ aParent, long /*int*/ aDialogTitle, long /*int*/ aText, int aCount, long /*int*/ aSelectList, long /*int*/ aOutSelection, long /*int*/ _retval) {
	return XPCOM.NS_ERROR_NOT_IMPLEMENTED;
}

}
