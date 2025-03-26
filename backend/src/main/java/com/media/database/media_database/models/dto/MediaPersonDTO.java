package com.media.database.media_database.models.dto;

import java.util.List;

import com.media.database.media_database.models.MediaPersonModel;
import com.media.database.media_database.models.joinTables.PersonRoleModel;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class MediaPersonDTO {
   private List<MediaPersonModel> people;
   private String role;

   public MediaPersonDTO(List<PersonRoleModel> personRoleModels){
       this.people = personRoleModels.stream()
           .map(PersonRoleModel::getPerson) // Convert PersonRoleModel to MediaPersonModel
           .collect(Collectors.toList());
       
       if (!personRoleModels.isEmpty()) {
           this.role = personRoleModels.get(0).getRole().toString(); // Set role if available
       }
   }

   public MediaPersonDTO(PersonRoleModel personRoleModel) {
       this.people = List.of(personRoleModel.getPerson()); // Convert single object to list
       this.role = personRoleModel.getRole().toString();
   }
}
