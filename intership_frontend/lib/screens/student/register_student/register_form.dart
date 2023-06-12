import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/bloc/cubit/student_cubit.dart';
import 'package:intership_frontend/bloc/states/student_state.dart';
import 'package:intership_frontend/services/globals.dart';
import 'package:intership_frontend/services/university_services.dart';

class FormRegister extends StatelessWidget {
  final int startYear;
  final int endYear;
  final _keyform;

  FormRegister({Key? key, required this.startYear, required this.endYear})
      : _keyform = GlobalKey<FormState>(),
        super(key: key);

  @override
  Widget build(BuildContext context) {
    List<String> years = [];
    for (int i = startYear; i <= endYear; i++) {
      years.add(i.toString());
    }
    return BlocBuilder<StudentCubit, StudentState>(builder: (context, state) {
      final listaDeCarreras = state.listaCarreras;
      return Padding(
        padding: EdgeInsets.all(10),
        child: SingleChildScrollView(
          child: Form(
            key: _keyform,
            child: Column(
              children: [
                TextFormField(
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return "Este campo es obligatorio";
                    }
                  },
                  decoration: InputDecoration(
                    hintText: "Nombres",
                    hintStyle: TextStyle(color: Colors.grey),
                    icon: Icon(Icons.person),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                  onChanged: (value) => BlocProvider.of<StudentCubit>(context)
                      .updateNombres(value),
                ),
                const SizedBox(
                  height: 10,
                ),
                TextFormField(
                  decoration: InputDecoration(
                    hintText: "Primer Apellido",
                    hintStyle: TextStyle(color: Colors.grey),
                    icon: Icon(Icons.person),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return "Este campo es obligatorio";
                    }
                  },
                  onChanged: (value) => BlocProvider.of<StudentCubit>(context)
                      .updatePrimerApellido(value),
                ),
                const SizedBox(
                  height: 10,
                ),
                TextFormField(
                  decoration: InputDecoration(
                    hintText: "Segundo Apellido",
                    hintStyle: TextStyle(color: Colors.grey),
                    icon: Icon(Icons.person),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return "Este campo es obligatorio";
                    }
                  },
                  onChanged: (value) => BlocProvider.of<StudentCubit>(context)
                      .updateSegundoApellido(value),
                ),
                const SizedBox(
                  height: 10,
                ),
                //seleccionar el tipo de documento, puede ser CI o Pasaporte
                DropdownButtonFormField(
                  items: <String>[
                    'Carnet de identidad',
                    'Pasaporte',
                  ].map((String value) {
                    return DropdownMenuItem<String>(
                      value: value,
                      child: Text(value),
                    );
                  }).toList(),
                  hint: const Text("Tipo de documento",
                      style: TextStyle(color: Colors.grey)),
                  icon: const Icon(Icons.arrow_drop_down),
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return "Este campo es obligatorio";
                    }
                  },
                  onChanged: (value) {
                    BlocProvider.of<StudentCubit>(context)
                        .updateTipoDocumento(value ?? '');
                  },
                ),
                const SizedBox(
                  height: 10,
                ),
                Row(
                  children: <Widget>[
                    Expanded(
                      flex: 2,
                      child: TextFormField(
                        decoration: InputDecoration(
                          hintText: "Número de documento",
                          hintStyle: TextStyle(color: Colors.grey),
                          icon: const Icon(Icons.book),
                          border: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(10),
                          ),
                        ),
                        validator: (value) {
                          if (value == null || value.isEmpty) {
                            return "Este campo es obligatorio";
                          }
                        },
                        onChanged: (value) =>
                            BlocProvider.of<StudentCubit>(context)
                                .updateNumeroDocumento(value),
                      ),
                    ),
                    const SizedBox(
                      width: 10,
                    ),
                    //Expanded para seleccionar el departamento solo si es CI
                    Expanded(
                      flex: 1,
                      child: DropdownButtonFormField(
                        items: <String>[
                          'LP',
                          'SCZ',
                          'PT',
                          'PN',
                          'OR',
                          'CH',
                          'CBB',
                          'TJ',
                          'BN'
                        ].map((String value) {
                          return DropdownMenuItem<String>(
                            value: value,
                            child: Text(value),
                          );
                        }).toList(),
                        hint: const Text("DPT",
                            style: TextStyle(color: Colors.grey)),
                        icon: const Icon(Icons.arrow_drop_down),
                        validator: (value) {
                          if (value == null || value.isEmpty) {
                            return "Este campo es obligatorio";
                          }
                        },
                        onChanged: (value) =>
                            BlocProvider.of<StudentCubit>(context)
                                .updateDepartamento(value ?? ''),
                      ),
                    )
                  ],
                ),
                const SizedBox(
                  height: 10,
                ),
                const Text(
                  "Validación con la UCB: ",
                  style: TextStyle(fontSize: 16),
                ),
                Row(
                  children: <Widget>[
                    Flexible(
                      fit: FlexFit.tight,
                      child: RadioListTile(
                        title: Text("Estudiante"),
                        value: 1,
                        groupValue: BlocProvider.of<StudentCubit>(context)
                            .state
                            .validacionUCB,
                        onChanged: (value) {
                          BlocProvider.of<StudentCubit>(context)
                              .updateValidacionUCB(value ?? 1);
                        },
                      ),
                    ),
                    Flexible(
                      fit: FlexFit.tight,
                      child: RadioListTile(
                        title: Text("Graduado"),
                        value: 2,
                        groupValue: BlocProvider.of<StudentCubit>(context)
                            .state
                            .validacionUCB,
                        onChanged: (value) {
                          BlocProvider.of<StudentCubit>(context)
                              .updateValidacionUCB(value ?? 2);
                        },
                      ),
                    ),
                  ],
                ),
                SizedBox(
                  height: 10,
                ),
                Card(
                  child: DropdownButtonFormField<String>(
                    items: ucbCampuses.map((String value) {
                      return DropdownMenuItem<String>(
                        value: value,
                        child: Text(value),
                      );
                    }).toList(),
                    hint: Text("Sede", style: TextStyle(color: Colors.grey)),
                    icon: Icon(Icons.arrow_drop_down),
                    validator: (value) {
                      if (value == null || value.isEmpty) {
                        return "Este campo es obligatorio";
                      }
                    },
                    onChanged: (String? value) {
                      BlocProvider.of<StudentCubit>(context)
                          .updateSede(value ?? '');
                      BlocProvider.of<StudentCubit>(context)
                          .getListaCarreras(value ?? '');
                      print("Lista de carreras: " +
                          state.listaCarreras.toString());
                    },
                  ),
                ),
                SizedBox(
                  width: 10,
                ),
                DropdownButtonFormField(
                  items: ucbCareers.map((String value) {
                    return DropdownMenuItem<String>(
                      value: value,
                      child: Text(value),
                    );
                  }).toList(),
                  hint: Text("Carrera", style: TextStyle(color: Colors.grey)),
                  icon: Icon(Icons.arrow_drop_down),
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return "Este campo es obligatorio";
                    }
                  },
                  onChanged: (String? value) {
                    BlocProvider.of<StudentCubit>(context)
                        .updateCarrera(value ?? '');
                  },
                ),
                SizedBox(
                  width: 10,
                ),
                DropdownButtonFormField(
                  items: years.map((String value) {
                    return DropdownMenuItem<String>(
                      value: value,
                      child: Text(value),
                    );
                  }).toList(),
                  hint: Text("Año de Ingreso",
                      style: TextStyle(color: Colors.grey)),
                  icon: Icon(Icons.arrow_drop_down),
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return "Este campo es obligatorio";
                    }
                  },
                  onChanged: (String? value) {
                    BlocProvider.of<StudentCubit>(context)
                        .updateAnioIngreso(value ?? '');
                  },
                ),
                SizedBox(
                  height: 10,
                ),
                TextFormField(
                  decoration: InputDecoration(
                    hintText: "Correo Electronico",
                    hintStyle: const TextStyle(color: Colors.grey),
                    icon: const Icon(Icons.email),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return "Este campo es obligatorio";
                    }
                  },
                  onChanged: (value) => BlocProvider.of<StudentCubit>(context)
                      .updateCorreoElectronico(value),
                ),
                const SizedBox(
                  height: 10,
                ),
                TextFormField(
                  decoration: InputDecoration(
                    hintText: "Contraseña",
                    hintStyle: const TextStyle(color: Colors.grey),
                    icon: const Icon(Icons.lock),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return "Este campo es obligatorio";
                    }
                    if (value.length <= 6) {
                      return "Contraseña muy corta";
                    }
                  },
                  onChanged: (value) => BlocProvider.of<StudentCubit>(context)
                      .updateContrasena(value),
                ),
                const SizedBox(
                  height: 10,
                ),
                TextFormField(
                  decoration: InputDecoration(
                    hintText: "Confirmar Contraseña",
                    hintStyle: const TextStyle(color: Colors.grey),
                    icon: const Icon(Icons.lock),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return "Este campo es obligatorio";
                    }
                  },
                  onChanged: (value) => BlocProvider.of<StudentCubit>(context)
                      .updateConfirmarContrasena(value),
                ),
                const SizedBox(
                  height: 10,
                ),
                ElevatedButton(
                  onPressed: () {
                    if (_keyform.currentState!.validate()) {
                      print("Validado");
                    }
                    //TODO: Validar que los campos no esten vacios
                    if (state.areAllFieldsFilled(state)) {
                      BlocProvider.of<StudentCubit>(context).addStudent(state);
                      print(state.toString());
                    } else {
                      print("No todos los campos estan llenos");
                      print(state.toString());
                    }
                  },
                  child: const Text("Registrate"),
                  style: ElevatedButton.styleFrom(
                    primary: Colors.blue.shade900,
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                ),
              ],
            ),
          ),
        ),
      );
    });
  }
}
