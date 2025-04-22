package clinic;

import java.util.ArrayList;
import java.util.List;

public class Physiotherapist extends Person {
    private List<String> expertise;
    private List<Treatment> treatments;

    public Physiotherapist(String id, String name, String address, String phone) {
        super(id, name, address, phone);
        this.expertise = new ArrayList<>();
        this.treatments = new ArrayList<>();
    }

    public List<String> getExpertise() {
        return expertise;
    }

    public void addExpertise(String area) {
        expertise.add(area);
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void addTreatment(Treatment treatment) {
        treatments.add(treatment);
    }

}