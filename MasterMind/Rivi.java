import java.util.Scanner;
public class Rivi {
	public String arvaus;

		public Rivi(){
			String arvaus = syotaRivi();
			this.arvaus=arvaus;
		}
		
	public String syotaRivi() {
		System.out.println("Syötä neljänumeroinen koodi (arvot 0-9) sallittuja: ");
		Scanner sc = new Scanner(System.in);
		arvaus = "";
		for (int i=0; i<100; i++) {
			String syote = sc.nextLine();
			if (syote.length()==4 && onkoSallittuArvo(syote)){  			
				arvaus = syote;	
				return arvaus;
				}
			else {
			System.out.println("Virheellinen syöte, yritä uudestaan. Syötä neljänumeroinen koodi, sallitut arvot 0-9.");
			}
		}
	return arvaus;	
	}
	
	public boolean onkoSallittuArvo(String s) {
		boolean onkoSallittu=true;
		for (int i=0; i<4; i++) {
			if (s.charAt(i) !='0' && s.charAt(i) !='1' && s.charAt(i) !='2' && s.charAt(i) !='3' && s.charAt(i) !='4' && s.charAt(i) !='5' && s.charAt(i) !='6' && s.charAt(i) !='7' && s.charAt(i) !='8' && s.charAt(i) !='9') {
				onkoSallittu=false;	
				}
		}
		return onkoSallittu;
	}
	public String palautaArvaus(){ 
		return arvaus; 
	}
			
}
