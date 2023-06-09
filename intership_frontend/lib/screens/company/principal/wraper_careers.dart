import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/bloc/cubit/intership_cubit.dart';
import 'package:intership_frontend/bloc/states/intership_state.dart';
import 'package:intership_frontend/services/globals.dart';

class WraperCareers extends StatelessWidget {
  final _keyform;
  WraperCareers({Key? key})
      : _keyform = GlobalKey<FormState>(),
        super(key: key);
  @override
  Widget build(BuildContext context) {
    return BlocBuilder<IntershipCubit, IntershipState>(
      builder: (context, state) {
        final listaDeCarreras = state.listacarreras;
        return SingleChildScrollView(
          child: Form(
            key: _keyform,
            child: Column(
              children: <Widget>[
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
                        return 'Este campo es obligatorio';
                      }
                      return null;
                    },
                    onChanged: (String? value) {},
                  ),
                ),
                SizedBox(
                  height: 20,
                ),
                Card(
                  child: DropdownButtonFormField(
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
                    onChanged: (value) {
                      BlocProvider.of<IntershipCubit>(context)
                          .updateCarrera(value ?? '');
                    },
                  ),
                ),
                SizedBox(
                  height: 20,
                ),
                /*ElevatedButton(
                    onPressed: () {
                      List<String> carrerasAux = ucbCareers
                          .where((carrera) => carreras.contains(carrera))
                          .toList();
                      BlocProvider.of<IntershipCubit>(context)
                          .updateListaCarreras(carrerasAux);
                    },
                    child: Text("Agregar"),
                    style: ElevatedButton.styleFrom(
                      primary: Colors.blue.shade900,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(10),
                      ),
                    )),*/
                /*Container(
                  child: ListView.builder(
                    itemCount: carreras.length,
                    shrinkWrap: true,
                    itemBuilder: (context, index) {
                      return Card(
                        child: ListTile(
                          title: Text(carreras[index]),
                          trailing: IconButton(
                            icon: Icon(Icons.delete),
                            onPressed: () {
                              carreras.removeAt(index);
                              List<String> carrerasAux = ucbCareers
                                  .where(
                                      (carrera) => carreras.contains(carrera))
                                  .toList();
                              BlocProvider.of<IntershipCubit>(context)
                                  .updateCarreras(carrerasAux);
                            },
                          ),
                        ),
                      );
                    },
                  ),
                ),*/
              ],
            ),
          ),
        );
      },
    );
  }
}
