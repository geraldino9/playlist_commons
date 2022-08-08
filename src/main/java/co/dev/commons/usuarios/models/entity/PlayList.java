package co.dev.commons.usuarios.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "playlist")
public class PlayList implements Serializable {
    /**
     *  Vars
     */
    @Id
    @Column(name = "playlist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable( name = "playlistsongs",
            joinColumns = @JoinColumn(name="playlist_id", insertable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name="song_id", insertable = false, updatable = false),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"playlist_id","song_id"})}
    )
    private Set<Songs> songs = new HashSet<Songs>();
//    private List<Songs> canciones;

//    @Transient
//    public boolean pruebaMapeo;


    /**
     * Constructors
     */
    public PlayList() {
    }


    /**
     * acces methods
     * @return
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Songs> getSongs() {
        return songs;
    }

//    public void setSongs(Set<Songs> songs) {
//        this.songs = songs;
//    }


//    public List<Songs> getCanciones() {
//        return canciones;
//    }
//
//    public void setCanciones(List<Songs> canciones) {
//        this.canciones = canciones;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        PlayList playList = (PlayList) o;
//        return id.equals(playList.id);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
