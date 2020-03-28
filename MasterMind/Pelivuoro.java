import java.util.Arrays;
import java.lang.StringBuilder;

public class Pelivuoro {
	protected String oikeaVastaus="1234";
	protected int kierros=0;
	protected boolean oikeaArvaus =false;
	protected int oikeaLuku = 0;
	protected int oikeaPaikka = 0;
	boolean[] oikeaPaikkaTosi = new boolean[4];

	public static void main(String[] args) {
		Pelivuoro peli = new Pelivuoro();
		}
	public Pelivuoro() {
		pelaa();
	}
		
	public void pelaa() {	
		Rivi r = new Rivi();
		String arvaus = r.palautaArvaus();
		boolean tarkistus = onkoOikea(arvaus, oikeaVastaus);
		if (tarkistus == true) {
			kierros++;
			System.out.println("Onneksi olkoon, selvitit koodin rivill‰ " + kierros+ "!");
		}
		else {
			oikeaPaikka = 0;
			Arrays.fill(oikeaPaikkaTosi, Boolean.FALSE);
			laskeOikeaPaikka(arvaus, oikeaVastaus);
			laskeOikeaLuku(arvaus, oikeaVastaus);
			kierros++;
			System.out.println("Oikeita numeroita oikealla paikalla "+oikeaPaikka+". Oikeita numeroita v‰‰r‰ll‰ paikalla "+oikeaLuku+". Olet yritt‰nyt arvata " + kierros+ " kertaa. Arvausyrityksi‰ j‰ljell‰:" + (12-kierros) );
			pelaa();
		}
	}
	public boolean onkoOikea(String a, String v) {
		if (a.equals(v)) {
			oikeaArvaus = true;
			}
	return oikeaArvaus; 
	}

	public void laskeOikeaPaikka(String a, String v) {
		for (int i=0; i<4; i++) {
			if (v.charAt(i)==a.charAt(i)) {
				oikeaPaikka++;
				oikeaPaikkaTosi[i]=true; 
			}
		}
		
	}
	
	public int laskeOikeaLuku(String a, String v){
		StringBuilder sbA = new StringBuilder();
		StringBuilder sbV = new StringBuilder();
//		int montaKertaaA = 0;
//		int montaKertaaV = 0;
		int i;
//		char[] A = new char[4];
//		char[] V = new char[4];
		
		
		for (i=0; i<4; i++) {
			if (oikeaPaikkaTosi[i]==false) {
				sbA.append(a.charAt(i));
				sbV.append(v.charAt(i));			
				}
			}
//		System.out.println(sbA.toString());
//		System.out.println(sbV.toString());
		oikeaLuku=laskeEsiintyma(sbA, sbV);
//		System.out.println(oikeaLuku);
//	laskeEsiintyma(sbV.toString());
		return oikeaLuku;
	}
	
	public int laskeEsiintyma(StringBuilder a, StringBuilder v ){ 
		int oikeaNroMaara=0;
//		Arrays[] arvausNro = new Arrays[9];
//		Arrays[] vastausNro = new Arrays[9]; 
		
		for (int i=0; i<9; i++) {
			int arvausMaara=laskeMonta(a, i);
//			System.out.println("Merkki‰" +i+" on arvauksessa " +arvausMaara);
			int vastausMaara=laskeMonta(v, i);
//			System.out.println("Merkki‰" +i+" on vastauksessa " +vastausMaara);
			if (vastausMaara >= arvausMaara) {
				oikeaNroMaara=oikeaNroMaara + arvausMaara;
			
			}			
		}
     return oikeaNroMaara;           
	} 
	
	public int laskeMonta(StringBuilder sb, int nro) {
		char etsiMerkki = (char) (nro + '0');
		int merkkiMaara=0;

		for (int i=0; i<sb.length(); i++) {
			if (sb.charAt(i)==etsiMerkki) {
				merkkiMaara++;
			}
		}
		return merkkiMaara;
	}
	
}
