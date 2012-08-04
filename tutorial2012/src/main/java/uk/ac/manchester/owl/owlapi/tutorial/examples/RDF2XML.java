/*
 * This file is part of the OWL API.
 *
 * The contents of this file are subject to the LGPL License, Version 3.0.
 *
 * Copyright (C) 2011, The University of Manchester
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 *
 * Alternatively, the contents of this file may be used under the terms of the Apache License, Version 2.0
 * in which case, the provisions of the Apache License Version 2.0 are applicable instead of those above.
 *
 * Copyright 2011, University of Manchester
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.manchester.owl.owlapi.tutorial.examples;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLXMLOntologyFormat;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import java.net.URI;

/**
 * <p>Simple example that reads an ontology then writes it out in OWL/XML</p>
 * <p/>
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Bio-Health Informatics Group<br>
 * Date: 11-Jan-2007<br>
 * <br>
 */
public class RDF2XML {

    public static void main(String[] args) {
        // A simple example of how to load and save an ontology
        try {
            /*
             * We first need to obtain a copy of an OWLOntologyManager, which,
             * as the name suggests, manages a set of ontologies. An ontology is
             * unique within an ontology manager. To load multiple copies of an
             * ontology, multiple managers would have to be used.
             */
            OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
            /* Load an ontology from a document IRI */
            System.out.println("In : " + args[0]);
            IRI documentIRI = IRI.create(args[0]);
            // Now do the loading
            OWLOntology ontology = manager.loadOntologyFromOntologyDocument(documentIRI);
            /*
             * Now save a copy to another location in OWL/XML format (i.e.
             * disregard the format that the ontology was loaded in)
             */
            System.out.println("Out: " + args[1]);
            IRI documentIRI2 = IRI.create(args[1]);
            manager.saveOntology(ontology, new OWLXMLOntologyFormat(), documentIRI2);
            /* Remove the ontology from the manager */
            manager.removeOntology(ontology);

        }
        catch (OWLException e) {
            e.printStackTrace();
        }
    }
}
