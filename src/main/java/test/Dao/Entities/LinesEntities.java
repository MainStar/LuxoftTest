package test.Dao.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lines")
public class LinesEntities {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "line")
    private String line;

    @Column(name = "longest_letter")
    private String longestLetter;

    @Column(name = "mid_letter")
    private String midLetter;

    @Column(name = "shortest_letter")
    private String shortestLetter;

    @ManyToOne
    @JoinColumn(name = "file_id", referencedColumnName = "id", insertable = false, updatable = false)
    private FileEntity file;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getLongestLetter() {
        return longestLetter;
    }

    public void setLongestLetter(String longestLetter) {
        this.longestLetter = longestLetter;
    }

    public String getMidLetter() {
        return midLetter;
    }

    public void setMidLetter(String midLetter) {
        this.midLetter = midLetter;
    }

    public String getShortestLetter() {
        return shortestLetter;
    }

    public void setShortestLetter(String shortestLetter) {
        this.shortestLetter = shortestLetter;
    }

    public FileEntity getFile() {
        return file;
    }

    public void setFile(FileEntity file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinesEntities that = (LinesEntities) o;
        return id == that.id &&
                Objects.equals(line, that.line) &&
                Objects.equals(longestLetter, that.longestLetter) &&
                Objects.equals(midLetter, that.midLetter) &&
                Objects.equals(shortestLetter, that.shortestLetter) &&
                Objects.equals(file, that.file);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, line, longestLetter, midLetter, shortestLetter, file);
    }

    @Override
    public String toString() {
        return "Lines: " +
                "id = " + id +
                ", line = " + line +
                ", longestLetter = " + longestLetter +
                ", midLetter = " + midLetter +
                ", shortestLetter = " + shortestLetter +
                ", file = " + file;
    }
}
