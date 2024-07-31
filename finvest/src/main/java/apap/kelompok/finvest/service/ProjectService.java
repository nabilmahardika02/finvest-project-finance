package apap.kelompok.finvest.service;

import apap.kelompok.finvest.model.ProjectModel;

import java.util.List;

public interface ProjectService {
    void addProject(ProjectModel project);

    List<ProjectModel> viewAllFinishedProject();

    List<ProjectModel> viewAllOngoingProject();
}
