package test.Dao.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "files")
public class FileEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "file", cascade = CascadeType.ALL)
    private Set<LinesEntities> lines = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<LinesEntities> getLines() {
        return lines;
    }

    public void setLines(Set<LinesEntities> lines) {
        this.lines = lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileEntity that = (FileEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(lines, that.lines);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, lines);
    }

    @Override
    public String toString() {
        return "File: " +
                "id = " + id +
                ", name = " + name +
                ", lines = " + lines;
    }
}
