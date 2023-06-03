import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/bloc/cubit/student_cubit.dart';
import 'package:intership_frontend/bloc/states/student_state.dart';
import 'package:intership_frontend/services/globals.dart';

class FormRegister extends StatelessWidget {
  final int startYear;
  final int endYear;
  const FormRegister({Key? key, required this.startYear, required this.endYear})
      : super(key: key);
  static List<String> carreras = [];
  @override
  Widget build(BuildContext context) {
    List<String> years = [];
    for (int i = startYear; i <= endYear; i++) {
      years.add(i.toString());
    }
    return BlocBuilder<StudentCubit,StudentState>(
        builder: (context,state){
          final listaDeCarreras = state.listaCarreras;
          return Padding(
            padding: EdgeInsets.all(10),
            child: SingleChildScrollView(
              child: Form(
                child: Column(
                  children: [
                    TextFormField(
                      decoration: InputDecoration(
                        hintText: "Nombres",
                        hintStyle: TextStyle(color: Colors.grey),
                        icon: Icon(Icons.person),
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(10),
                        ),
                      ),
                      onChanged: (value) => BlocProvider.of<StudentCubit>(context).updateNombres(value),
                    ),
                    SizedBox(
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
                      onChanged: (value) => BlocProvider.of<StudentCubit>(context).updatePrimerApellido(value),
                    ),
                    SizedBox(
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
                      onChanged: (value) => BlocProvider.of<StudentCubit>(context).updateSegundoApellido(value),
                    ),
                    const SizedBox(
                      height: 10,
                    ),
                    //seleccionar el tipo de documento, puede ser CI o Pasaporte
                    DropdownButton(
                      items: <String>[
                        'Carnet de identidad',
                        'Pasaporte',
                      ].map((String value) {
                        return DropdownMenuItem<String>(
                          value: value,
                          child: Text(value),
                        );
                      }).toList(),
                      hint: const Text("Tipo de documento", style: TextStyle(color: Colors.grey)),
                      icon: const Icon(Icons.arrow_drop_down),
                      onChanged: (value) => BlocProvider.of<StudentCubit>(context).updateTipoDocumento(value??''),
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
                            onChanged: (value) => BlocProvider.of<StudentCubit>(context).updateNumeroDocumento(value),
                          ),
                        ),
                        const SizedBox(
                          width: 10,
                        ),
                        //Expanded para seleccionar el departamento solo si es CI
                        Expanded(
                          flex: 1,
                          child: DropdownButton<String>(
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
                            hint: const Text("DPT", style: TextStyle(color: Colors.grey)),
                            icon: const Icon(Icons.arrow_drop_down),
                            onChanged: (value) => BlocProvider.of<StudentCubit>(context).updateDepartamento(value??''),
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
                            groupValue: 1,
                            onChanged: (value) {
                              BlocProvider.of<StudentCubit>(context).updateValidacionUCB(value??1);
                            },
                          ),
                        ),
                        Flexible(
                          fit: FlexFit.tight,
                          child: RadioListTile(
                            title: Text("Graduado"),
                            value: 2,
                            groupValue: 1,
                            onChanged: (value) {
                              BlocProvider.of<StudentCubit>(context).updateValidacionUCB(value??1);
                            },
                          ),
                        ),
                      ],
                    ),
                    SizedBox(
                      height: 10,
                    ),
                    DropdownButton(
                      items: ucbCampuses
                          .map((String value) {
                        return DropdownMenuItem<String>(
                          value: value,
                          child: Text(value),
                        );
                      }).toList(),
                      hint: Text("Sede", style: TextStyle(color: Colors.grey)),
                      icon: Icon(Icons.arrow_drop_down),
                      onChanged: (String? value) {
                        //TODO: cambiar la lista de carreras dependiendo de la sede
                        carreras = [];
                        ucbCareers.forEach((element) {
                          //Dividir el string en dos partes, el nombre de la carrera y la sedes
                          List<String> career = element.split(":");
                          //Dividir las sedes en un arreglo
                          List<String> campuses = career[1].split(",");
                          //Si la sede seleccionada esta en el arreglo de sedes de la carrera, agregarla a la lista de carreras
                          if (campuses.contains(value)) {
                            carreras.add(career[0]);
                          }
                        });
                        BlocProvider.of<StudentCubit>(context).updateSede(value??'');
                        BlocProvider.of<StudentCubit>(context).updateListaCarreras(carreras);
                      },
                    ),
                    SizedBox(
                      width: 10,
                    ),
                    DropdownButton(
                      items: listaDeCarreras.map((String value) {
                        return DropdownMenuItem<String>(
                          value: value,
                          child: Text(value),
                        );
                      }).toList(),
                      hint: Text("Carrera", style: TextStyle(color: Colors.grey)),
                      icon: Icon(Icons.arrow_drop_down),
                      onChanged: (String? value) {
                        BlocProvider.of<StudentCubit>(context).updateCarrera(value??'');
                      },
                    ),
                    SizedBox(
                      width: 10,
                    ),
                    DropdownButton(
                      items: years.map((String value) {
                        return DropdownMenuItem<String>(
                          value: value,
                          child: Text(value),
                        );
                      }).toList(),
                      hint: Text("Año de Ingreso",
                          style: TextStyle(color: Colors.grey)),
                      icon: Icon(Icons.arrow_drop_down),
                      onChanged: (String? value) {},
                    ),
                    const SizedBox(
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
                    ),
                    const SizedBox(
                      height: 10,
                    ),
                    TextFormField(
                      decoration: InputDecoration(
                        hintText: "Contraseña",
                        hintStyle: const TextStyle(color: Colors.grey),
                        icon:const Icon(Icons.lock),
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(10),
                        ),
                      ),
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
                    ),
                    const SizedBox(
                      height: 10,
                    ),
                    ElevatedButton(
                      onPressed: () {
                        //Obtener los datos del formulario
                        print(state.toString());
                        //TODO: Validar los datos ingresados
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
        }
    );
  }
}
