package br.com.apivalidadorcpf.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.io.Serializable;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor(staticName = "created")
public class Status implements Serializable {

    private static final long serialVersionUID = -45482769156638620L;

    private String status;
}
