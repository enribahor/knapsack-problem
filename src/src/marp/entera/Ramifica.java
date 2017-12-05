package marp.entera;

public class Ramifica {

		public MochilaEntera ejecutaRamificacion(ObjetoMochilaEntera[] objetos, int capacidad){
			
			
			return mochila;
		}
		
		private void ramification(){

            this.borneInf = 0;
            this.weight = 0;
            this.solution = null;
            this.numNodeExplore = 0;
            this.nodeStack = new LinkedList<>();

            int nextObj = heuristique.nextObj();

            if (nextObj < 0) {
                    //cas ou le nombre d'iteme est nulle
                    return;
            }

            //doit t'on d'abord examiné le cas ou l'objet est dans le sac ?
            boolean firstInBag = heuristique.brancherDabordSurVrai();

            //le dernier noeud mis dans la pile sera le premier examiné
            nodeStack.push(new Node(nextObj, EtatObject.fromBool(!firstInBag)));
            nodeStack.push(new Node(nextObj, EtatObject.fromBool(firstInBag)));

            Node currentNode;
            //l'algo fini quand tout il n'y a plus de noeud a examiner
            while (!nodeStack.isEmpty()) {

                    //on prend le noeud au dessus de la pile
                    currentNode = nodeStack.peek();

                    if (currentNode.isExplored()) {
                            //si le noeud a déjà été exploré on backtrack
                            ub.fix(currentNode.getIdObj(), EtatObject.FREE);

                            //Puis on l'enlève de la pile
                            nodeStack.pop();

                            //oui j'assume
                            continue;
                    }

                    //sinon on explore ce noeud
                    numNodeExplore++;

                    //on effectue le branchement correspondant au noeud
                    ub.fix(currentNode.getIdObj(), currentNode.getEtatObject());

                    //on calcule la borne min et sa solution correspondante ainsi qu'une borne max
                    ub.compute();

                    //si la solution de la borne min du noeud est meilleur que celle trouvé precedamment on l'a
                    //sauvegarde
                    if (ub.getBorneInf() > borneInf) {
                            borneInf = ub.getBorneInf();
                            weight = ub.getBorneInfWeight();
                            solution = ub.getBorneInfSol();
                    }

                    //on détermine le prochain branchement a effectué depuis ce noeud
                    nextObj = heuristique.nextObj();

                    //on sait qu'on peut elager la branche sioit si:
                    //      - il n'y a pas d'objet qu'on peut rajouter dans le sac (nextObj < 0)
                    //      - la borne max calculé par ub admet une solution commune (c'est la même que
                    //      celle de la borne min du noeud) (ub.borneAUneSolution() == True)
                    //      - la borne max du noeud est inférieur ou egal à la valeur de la meilleur solution précédamment trouvé
                    //        dans ce cas tout les noeuds fils de ce noeud ne trouveront jamais un noeud meilleur
                    if (!(nextObj < 0 || ub.borneAUneSolution() || (ub.getBorneSup() <= borneInf))) {

                            //si la branche ne peut pas être élager on empile les noeuds fils du noeud sur la stack
	                                firstInBag = heuristique.brancherDabordSurVrai();
	                                nodeStack.push(new Node(nextObj, EtatObject.fromBool(!firstInBag)));
	                                nodeStack.push(new Node(nextObj, EtatObject.fromBool(firstInBag)));
	                        }

	                        currentNode.setExplored(true);
	                }

	                assert(data.solutionAcceptable(solution));
	        }
			
			
}
