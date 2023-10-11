package santarelli.enrico.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import santarelli.enrico.domain.enums.Status;

@Entity(name = "tb_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Column(nullable = true, length = 100)
    private String description;

    private Integer iconCodePoint;

    @Size(max = 5, min = 1)
    private Integer difficulty;

    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIconCodePoint() {
        return iconCodePoint;
    }

    public void setIconCodePoint(Integer iconCodePoint) {
        this.iconCodePoint = iconCodePoint;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
