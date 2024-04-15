package com.udea.driver2023.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(description = "All details about flight")
@Entity
public class Flight implements Serializable {
@ApiModelProperty(notes = "The DB generated ID Flight")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idflight")
    private Long idFlight;

    @ApiModelProperty(notes = "nombre Avion")
    @Column(name="nombreavion", nullable=false, length=80)
    private @NonNull String nombreAvion;

    @ApiModelProperty(notes = "Numero Vuelo")
    @Column(name="numerovuelo", nullable=false, length=80)
    private @NonNull String numeroVuelo;

    @ApiModelProperty(notes = "origen")
    @Column(name="origen", nullable=false, length=80)
    private @NonNull String origen;

    @ApiModelProperty(notes = "destino")
    @Column(name="destino", nullable=false, length=80)
    private @NonNull String destino;

    @ApiModelProperty(notes = "capacidad")
    @Column(name="capacidad", nullable=false, length=80)
    private @NonNull int capacidad;

    @ApiModelProperty(notes = "Rating")
    @Column(name="rating", nullable=false, length=80)
    @Min(value=1, message="id should be more or than equal 1")
    @Max(value=5, message="id should be less or than equal 5")
    private @NonNull int rating;

    @ApiModelProperty(notes = "plan vuelo")
    @Column(name="planvuelo", nullable=false, length=80)
    private @NonNull long planvuelo;

    @ApiModelProperty(notes = "Cumplido")
    private Boolean cumplido;

}