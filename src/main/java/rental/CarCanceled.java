package rental;

public class CarCanceled extends AbstractEvent {

    private Long id;

    public CarCanceled(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
