package app;

import customer.*;
import marketplace.*;

/* DO NOT MODIFY THIS FILE */
class Main {
	public static void main(String[] args){
		Marketplace marketplace = new Marketplace("TechMeNot Gadget Marketplace");
		
		Customer guzman = new Customer("Guzman Nunier","Calamba, Laguna","09998765431",160000);
		Customer ander = new Customer("Ander Munoz","San Pedro, Laguna","09998765432",170000);
		Customer carla = new RebateCustomer("Carla Roson","Los Banos, Laguna","09998765433",180000);
		Customer nadia = new RebateCustomer("Nadia Shanaa","Bay, Laguna","09998765434",90000);
		Customer samuel = new Customer("Samuel Dominguez","San Pablo, Laguna","09998765435",9000);
	
		Gadget[] gadgets = {
			new Gadget("Nikon", "Z50", 35000, Gadget.COND_LIKE_NEW, Gadget.CLASS_CAMERA),
			new Gadget("GoPro", "Hero 8", 14500, Gadget.COND_LIKE_NEW, Gadget.CLASS_CAMERA),
			new Gadget("Canon", "EOS M6", 15510, Gadget.COND_GOOD, Gadget.CLASS_CAMERA),
			new Gadget("Nikon", "D3", 70000, Gadget.COND_MINT, Gadget.CLASS_CAMERA),
			new Gadget("Fujifilm", "X-A3", 10000, Gadget.COND_MINT, Gadget.CLASS_CAMERA),
			new Gadget("Asus", "ROG Phone II", 16000, Gadget.COND_GOOD, Gadget.CLASS_MOBILE),
			new Gadget("Samsung", "Galaxy S10+", 23000, Gadget.COND_MINT, Gadget.CLASS_MOBILE),
			new Gadget("Apple", "iPhone 6", 4500, Gadget.COND_GOOD, Gadget.CLASS_MOBILE),
			new Gadget("Apple", "iPhone 12 Pro", 47000, Gadget.COND_LIKE_NEW, Gadget.CLASS_MOBILE),
			new Gadget("Realme", "C12", 5400, Gadget.COND_GOOD, Gadget.CLASS_MOBILE),
			new Gadget("Lenovo", "ThinkPad E580", 15990, Gadget.COND_GOOD, Gadget.CLASS_COMPUTER),
			new Gadget("Apple", "Macbook Air 2015", 25000, Gadget.COND_GOOD, Gadget.CLASS_COMPUTER),
			new Gadget("Asus", "X555LAB", 12999, Gadget.COND_GOOD, Gadget.CLASS_COMPUTER),
			new Gadget("Acer", "Swift 3 Ultrabook", 19900, Gadget.COND_GOOD, Gadget.CLASS_COMPUTER),
			new Gadget("Apple", "Macbook Air M1", 48000, Gadget.COND_LIKE_NEW, Gadget.CLASS_COMPUTER)
		};

		for (int i=0; i<gadgets.length; i++) {
			marketplace.add(gadgets[i]);
		}

		guzman.buy(gadgets[0], marketplace);
		guzman.buy(gadgets[5], marketplace);
		guzman.buy(gadgets[11], marketplace);
		guzman.viewState();
		marketplace.viewProducts();

		carla.buy(gadgets[1], marketplace);
		carla.buy(gadgets[6], marketplace);
		carla.buy(gadgets[12], marketplace);
		carla.viewState();
		marketplace.viewProducts();

		ander.buy(gadgets[2], marketplace);
		ander.buy(gadgets[7], marketplace);
		ander.buy(gadgets[13], marketplace);
		ander.viewState();
		marketplace.viewProducts();

		nadia.buy(gadgets[0], marketplace);
		nadia.viewState();

		samuel.buy(gadgets[4], marketplace);
		samuel.viewState();

		guzman.buy(gadgets[8], marketplace);
		guzman.viewState();

		nadia.buy(gadgets[14], marketplace);
		nadia.viewState();

		marketplace.viewInfo();
	}
}
