import com.clarkparsia.owlapiv3.OWL;
//import com.clarkparsia.pellet.owlapiv3.PelletReasoner;
//import com.clarkparsia.pellet.owlapiv3.PelletReasonerFactory;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import org.mindswap.pellet.jena.PelletReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.*;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;
import org.semanticweb.owlapi.util.InferredAxiomGenerator;
import org.semanticweb.owlapi.util.InferredOntologyGenerator;
import org.semanticweb.owlapi.util.InferredPropertyAssertionGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreateProperty {

    private  static  final String DOC_URL = "http://www.semanticweb.org/anast/ontologies/2019/3/ont_PS.owl";

    public static void main (String[] args)  {
        // BuiltInRegistry.instance.registerBuiltIn("urn:makub:builtIn#IRIparts", new CustomSWRLBuiltin(new IRIparts()));


//        InputStream owlInputStream = null;
//        try {
//            Model shema = FileManager.get().loadModel("C:\\Users\\anast\\Desktop\\magistratura\\project\\ontologies\\ont_PS1.owl");
//            Model data = FileManager.get().loadModel("C:\\Users\\anast\\Desktop\\magistratura\\project\\ontologies\\ont_PS.rdf");
//            Reasoner reasoner = ReasonerRegistry.getOWLMiniReasoner();
//            reasoner = reasoner.bindSchema(shema);
//            InfModel inf = ModelFactory.createInfModel(reasoner, data);



           OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
          // IRI iri = IRI.create("http://www.semanticweb.org/anast/ontologies/2019/3/ont_PS.owl");
           File file = new File("C:\\Users\\anast\\Desktop\\magistratura\\project\\ontologies\\ont_17.owl");
        OWLOntology ontology = null;
        try {
            // ontology = manager.loadOntologyFromOntologyDocument(iri);
            ontology = manager.loadOntologyFromOntologyDocument(file);
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
        }
        System.out.println("Load ontology: " + ontology);
        OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
        ConsoleProgressMonitor progressMonitor = new ConsoleProgressMonitor();
        OWLReasonerConfiguration config = new SimpleConfiguration(progressMonitor);
        OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);
        reasoner.precomputeInferences();


//            owlInputStream = new FileInputStream("C:\\Users\\anast\\Desktop\\magistratura\\project\\ontologies\\ont_PS1.owl");
//            // OWLOntology ontology = manager.loadOntologyFromOntologyDocument(owlInputStream);
////            OWLOntology ontology = manager.loadOntologyFromOntologyDocument(IRI.create(DOC_URL));
//            OWLOntology ontology = OWL.manager.loadOntologyFromOntologyDocument(owlInputStream);
//            OWLDataFactory factory = manager.getOWLDataFactory();
//            PelletReasoner pellet = PelletReasonerFactory.getInstance().createReasoner(ontology, new SimpleConfiguration());
//            pellet.getKB().realize();
//            List<InferredAxiomGenerator<? extends OWLAxiom>> axiomGenerators = new ArrayList<InferredAxiomGenerator<? extends OWLAxiom>>();
//            axiomGenerators.add(new InferredPropertyAssertionGenerator());
//
//            InferredOntologyGenerator gen = new InferredOntologyGenerator(pellet, axiomGenerators);
//            gen.fillOntology(manager, ontology);


          //  OutputStream owlOutput = new FileOutputStream("C:\\Users\\anast\\Desktop\\magistratura\\project\\ontologies\\ont_resoner");
//            manager.saveOntology(ontology, owlOutput);


//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (OWLOntologyCreationException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


     }
    }
