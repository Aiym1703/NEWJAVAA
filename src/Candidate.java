class Candidate extends Entity {
    private String name;

    public Candidate(int id, String name) {
        super(id);
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Candidate: " + name+ " (ID: " + getId() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false; // Проверяем равенство ID
        Candidate candidate = (Candidate) obj;
        return name.equals(candidate.name);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + name.hashCode();
    }

}
