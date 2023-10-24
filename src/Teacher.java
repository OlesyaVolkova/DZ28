public class Teacher extends Human {
    private String spesiality;
    private int experience;

    public String getSpesiality() {
        return spesiality;
    }

    public int getExperience() {
        return experience;
    }

    public void setSpesiality(String spesiality) {
        this.spesiality = spesiality;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Teacher(String lastName, String firstName, int age, String spesiality, int experience) {
        super(lastName, firstName, age);
        setSpesiality(spesiality);
        setExperience(experience);
        System.out.println("TConstructor:\t" + Integer.toHexString(hashCode()));
    }

    public void init(String[] values) {
        super.init(values);
        spesiality = values[4];
        experience = Integer.parseInt(values[5]);
    }

    public String toString() {
        return super.toString() + ", " + spesiality + ", " + experience;
    }
}
