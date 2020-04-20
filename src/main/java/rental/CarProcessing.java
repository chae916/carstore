package rental;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="CarProcessing_table")
public class CarProcessing {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @PostPersist
    public void onPostPersist(){
        CarRegistered carRegistered = new CarRegistered();
        BeanUtils.copyProperties(this, carRegistered);
        carRegistered.publish();


    }

    @PostRemove
    public void onPostRemove(){
        CarCanceled carCanceled = new CarCanceled();
        BeanUtils.copyProperties(this, carCanceled);
        carCanceled.publish();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
