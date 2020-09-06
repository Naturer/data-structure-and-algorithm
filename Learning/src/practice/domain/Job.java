package practice.domain;

public class Job {

    Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Job(Company company) {
        this.company = company;
    }
}
