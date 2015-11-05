package es.ugr.gprulerefinement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import es.ugr.gprulerefinement.variables.Action;
import es.ugr.gprulerefinement.variables.Variable;
import es.ugr.osgiliath.OsgiliathService;
import es.ugr.osgiliath.evolutionary.basiccomponents.genomes.GenericTreeNode;
import es.ugr.osgiliath.evolutionary.basiccomponents.genomes.TreeGenome;
import es.ugr.osgiliath.evolutionary.basiccomponents.individuals.DoubleFitness;
import es.ugr.osgiliath.evolutionary.elements.FitnessCalculator;
import es.ugr.osgiliath.evolutionary.individual.Fitness;
import es.ugr.osgiliath.evolutionary.individual.Individual;

public class GPRuleRefinementFitnessCalculator  extends OsgiliathService implements FitnessCalculator{

	@Override
	public Fitness calculateFitness(Individual ind) {
		TreeGenome tg = (TreeGenome) ind.getGenome();
		
		return new DoubleFitness(new Double(new Random().nextDouble()), true);
	}

	@Override
	public ArrayList<Fitness> calculateFitnessForAll(ArrayList<Individual> inds) {
		ArrayList<Fitness> fits = new ArrayList<Fitness>();

		for (Individual ind : inds) {
			Fitness f = this.calculateFitness(ind);
			fits.add(f);
		}
		return fits;
	}

	public static String writeTree(TreeGenome tg){

		System.out.println(tg.toStringWithDepth());

		List<GenericTreeNode> leafs = new ArrayList<GenericTreeNode>();
		for(GenericTreeNode n:tg.getNodeList()){
			if(!n.hasChildren())
				leafs.add(n);
				
		}
		String arbol = "";
		for(GenericTreeNode v:leafs){
			Action action = (Action)v.getData();
			GenericTreeNode p = v.getParent();
			while(p.getParent()!=null){
				arbol = arbol + p.toString()+" AND ";
				p = p.getParent();
			}
			arbol = arbol + p.toString()+" ";
			arbol = arbol+action.toString();
			arbol = arbol+"\n";
		}
		System.out.println(arbol);
		return arbol;
		
	}
}