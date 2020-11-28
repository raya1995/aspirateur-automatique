package fr.yp.view;

import java.util.List;

import fr.yp.controller.OrderController;
import fr.yp.model.IHooverModel;
import fr.yp.model.ParameterModel;
import fr.yp.util.FileUtil;

public class Main {

	public static void main(String[] args) {
		System.out.println(":: Bienvenu dans IHoover ::");

		// On positionne la valeur de fichier par défaut à iHoover
		String path = "iHoover";
		// On détecte si un autre fichier d'entrée est positionné
		if (args.length == 1) {
			path = args[0];
		}
		// on parse le fichier
		List<String> lines = FileUtil.getFileLines(path);

		// 1
		System.out.println("1) Récupération du contenu du fichier");
		System.out.println("lignes " + lines);

		// 2
		System.out.println("2) Récupération des objets");
		ParameterModel parameter = new ParameterModel(lines);
		System.out.println("Grid : " + parameter.getGrid());
		System.out.println("iHoover : " + parameter.getIHoover());
		System.out.println("Orders : " + parameter.getOrders());

		// 3
		System.out.println("3) Résultat");
		IHooverModel iHooverArrived = OrderController.getArrivedIHoover(parameter.getGrid(), parameter.getIHoover(),
				parameter.getOrders());
		System.out.println("iHoover à l'arrivé " + iHooverArrived);

		// fin
		System.out.println(":: Fin du programme ::");
	}

}
