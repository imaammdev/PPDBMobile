package id.ac.ub.ptiik.labmobile.ppdbmobile.base;

import java.util.ArrayList;

public class Siswa {
	private String nama;
	private String nomorUjian;
	private Sekolah sekolahDiterima;
	private Sekolah sekolahAsal;
	private JenisKelamin jenisKelamin;
	private String tempatLahir;
	private int tanggalLahir, bulanLahir, tahunLahir;
	private ArrayList<NilaiUjian> NUN;
	
	public Siswa(String nama, String nomorUjian) {
		this.nama = nama;
		this.nomorUjian = nomorUjian;
	}
	
	public Sekolah getSekolahAsal() {
		return this.sekolahAsal;
	}
	
	public String getNamaSekolahAsal() {
		if(this.sekolahAsal != null)
			return this.sekolahAsal.nama;
		else return "";
	}
	
	public String getJenisKelamin() {
		if(this.jenisKelamin.equals(JenisKelamin.LakiLaki))
			return "Laki-laki";
		else return "Perempuan";
	}
	
	public void setJenisKelamin(JenisKelamin jenis) {
		this.jenisKelamin = jenis;
	}
	
	public void setTempatTanggalLahir(String tempat, int tanggal, int bulan, int tahun) {
		this.tempatLahir = tempat;
		this.tanggalLahir = tanggal;
		this.bulanLahir = bulan;
		this.tahunLahir = tahun;
	}
	
	public String getTempatTanggalLahir() {
		return this.tempatLahir 
				+ ", " + this.tanggalLahir 
				+ " " + Bulan.getNamaBulan(this.bulanLahir)
				+ " " + this.tahunLahir;
	}
	
	public void diterima(Sekolah sekolah) {
		this.sekolahDiterima = sekolah;
	}
	
	public void setSekolahAsal(Sekolah sekolah) {
		this.sekolahAsal = sekolah;
	}
	
	public String getNama() {
		return this.nama;
	}
	
	public String getNomorUjian() {
		return this.nomorUjian;
	}
	
	public Sekolah getSekolahDiterima() {
		return this.sekolahDiterima;
	}
	
	public void setNUN(ArrayList<NilaiUjian> nun) {
		this.NUN = nun;
	}
	
	public void addNilaiUjian(NilaiUjian nu) {
		if(this.NUN == null)
			this.NUN = new ArrayList<NilaiUjian>();
		this.NUN.add(nu);
	}
	
	public ArrayList<NilaiUjian> getNUN() {
		return this.NUN;
	}
}
