/*******************************************************************************
 * Copyright (c) 2010, 2014 Obeo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *      Obeo - initial API and implementation
 *******************************************************************************/
int monOperationC(int *par1, char secondPar, INT32 ****Status);

int monOperationC(int *par1, char secondPar, INT32 ****Status) {
	   /* mise de l'adresse de commande dans le buffer de communication */
	   buffer[C_IDENTIFIANT] = C_ADR_STATUT_SL;
	   buffer[C_OCTET1] = 0;
	   buffer[C_OCTET2] = 0;
}
