// Nama: Muhammad
// NPM : 2410010593
package id.ac.uniska.pbo2.uts;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NilaiTableModel extends AbstractTableModel {
    private final List<NilaiMahasiswa> daftarNilai = new ArrayList<>();
    private final String[] namaKolom = {"NPM", "Nama", "Tugas", "UTS", "UAS", "Akhir", "Huruf"};

    public void tambahNilai(NilaiMahasiswa nilai) {
        daftarNilai.add(nilai);
        fireTableRowsInserted(daftarNilai.size() - 1, daftarNilai.size() - 1);
    }

    public boolean isNpmExist(String npm) {
        for (NilaiMahasiswa m : daftarNilai) {
            if (m.getNpm().equals(npm)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getRowCount() {
        return daftarNilai.size();
    }

    @Override
    public int getColumnCount() {
        return namaKolom.length;
    }

    @Override
    public String getColumnName(int column) {
        return namaKolom[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NilaiMahasiswa m = daftarNilai.get(rowIndex);
        switch (columnIndex) {
            case 0: return m.getNpm();
            case 1: return m.getNama();
            case 2: return m.getTugas();
            case 3: return m.getUts();
            case 4: return m.getUas();
            case 5: return String.format(Locale.GERMANY, "%.2f", m.getNilaiAkhir());
            case 6: return m.getHurufMutu();
            default: return null;
        }
    }

    public int getJumlahMahasiswa() {
        return daftarNilai.size();
    }

    public double getRataRataNilaiAkhir() {
        if (daftarNilai.isEmpty()) return 0.0;
        double total = 0;
        for (NilaiMahasiswa m : daftarNilai) {
            total += m.getNilaiAkhir();
        }
        return total / daftarNilai.size();
    }

    public String getRingkasanText() {
        return String.format(Locale.GERMANY, "Jumlah mahasiswa: %d, rata-rata nilai akhir: %.2f",
                getJumlahMahasiswa(), getRataRataNilaiAkhir());
    }
}