package id.ac.ub.ptiik.labmobile.ppdbmobile.base;

public class Pendaftaran {
	private String nomorPendaftaran;
	private JenisSeleksi seleksi;
	private Sekolah sekolahLokasiDaftar;
	private String tanggalDaftar;
	private String jamDaftar;
	
	public Pendaftaran(String nomorPendaftaran, JenisSeleksi seleksi, Sekolah sekolahLokasiDaftar
			, String tanggalDaftar, String jamDaftar) {
		this.nomorPendaftaran = nomorPendaftaran;
		this.seleksi = seleksi;
		this.sekolahLokasiDaftar = sekolahLokasiDaftar;
		this.tanggalDaftar = tanggalDaftar;
		this.jamDaftar = jamDaftar;
	}
	
	public String getNomorPendaftaran() {
		return this.nomorPendaftaran;
	}
	
	public String getJenisSeleksi() {
		if(this.seleksi.equals(JenisSeleksi.Reguler))
			return "Reguler";
		else return "";
	}
	
	public String getNamaSekolahLokasiDaftar() {
		if(this.sekolahLokasiDaftar != null)
			return this.sekolahLokasiDaftar.nama;
		else return "";
	}
	
	public String getWaktuDaftar() {
		return this.tanggalDaftar + ", " + this.jamDaftar;
	}
}
