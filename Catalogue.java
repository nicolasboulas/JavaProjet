package Metier;

import java.util.ArrayList;
import java.util.List;

public class Catalogue implements I_Catalogue {
	
	private ArrayList<I_Produit> lesProduits;

	public Catalogue() {
		lesProduits = new ArrayList<I_Produit>();
	}
	
	@Override
	public boolean addProduit(I_Produit produit) {
		boolean res = true;
		int ancienneTaille = lesProduits.size();
		lesProduits.add(produit);
		return (lesProduits.size() > ancienneTaille);
	}

	@Override
	public boolean addProduit(String nom, double prix, int qte) {
		I_Produit nouveauProduit = new Produit(nom,qte,prix);
		return addProduit(nouveauProduit);
	}

	@Override
	public int addProduits(List<I_Produit> l) {
		lesProduits = (ArrayList<I_Produit>) l;
		return lesProduits.size();
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public boolean removeProduit(String nom) {
		lesProduits.remove(nom);
		return false;
	}

	@Override
	public boolean acheterStock(String nomProduit, int qteAchetee) {
		boolean res = true;
		
		if (qteAchetee != 0)
		{
		I_Produit l_Produit = new Produit(nomProduit,qteAchetee, 0);
		lesProduits.add(l_Produit);
		}
		else
		{
			res = false;;
		}
		
		return res;
	}

	@Override
	public boolean vendreStock(String nomProduit, int qteVendue) {
		
		return false;
	}

	@Override
	public String[] getNomProduits() {
	
		String[] nom = new String[lesProduits.size()];
		
		for (int i = 0; i < lesProduits.size(); i++) 
		{
			nom[i] = lesProduits.get(i).getNom(); 
		}

		return nom;
	}

	@Override
	public double getMontantTotalTTC() {
		
		double MontantTotal = 0;
		
		for (int i = 0; i < lesProduits.size(); i++) 
		{
			MontantTotal = MontantTotal + lesProduits.get(i).getPrixStockTTC();
		}
		return MontantTotal;
	}

	@Override
	public void clear() 
	{
		lesProduits.clear();
	}

}
