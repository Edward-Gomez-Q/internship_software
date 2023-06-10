import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/bloc/cubit/intership_cubit.dart';
import 'package:intership_frontend/bloc/states/intership_state.dart';
import 'package:intership_frontend/services/globals.dart';

class WraperCareers extends StatelessWidget {
  List<String> carreras = [];
  @override
  Widget build(BuildContext context) {
    return BlocBuilder<IntershipCubit, IntershipState>(
      builder: (context, state) {
        return SingleChildScrollView(
          child: Column(
            children: <Widget>[
              DropdownButtonFormField(
                items: facultad.map((String value) {
                  return DropdownMenuItem<String>(
                    value: value,
                    child: Text(value),
                  );
                }).toList(),
                hint: Text("Facultad", style: TextStyle(color: Colors.grey)),
                icon: Icon(Icons.arrow_drop_down),
                onChanged: (String? value) {
                  BlocProvider.of<IntershipCubit>(context)
                      .updateFacultad(value ?? '');
                },
              ),
              SizedBox(
                height: 20,
              ),
              DropdownButtonFormField(
                items: ucbCareers.map((String value) {
                  return DropdownMenuItem<String>(
                    value: value,
                    child: SizedBox(
                        width: 200,
                        child: ListTile(
                          title: Text(value),
                          trailing: carreras.contains(value)
                              ? Icon(Icons.check)
                              : null,
                          onTap: () {
                            if (carreras.contains(value)) {
                              carreras.remove(value);
                            } else {
                              carreras.add(value);
                            }
                            BlocProvider.of<IntershipCubit>(context)
                                .updateListaCarreras(carreras);
                          },
                        )),
                  );
                }).toList(),
                hint: Text("Carreras", style: TextStyle(color: Colors.grey)),
                icon: Icon(Icons.arrow_drop_down),
                onChanged: (value) {},
              ),
              SizedBox(
                height: 20,
              ),
              ElevatedButton(
                  onPressed: () {},
                  child: Text("Agregar"),
                  style: ElevatedButton.styleFrom(
                    primary: Colors.blue.shade900,
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  )),
              SizedBox(
                height: 20,
              ),
              Container(
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
                          },
                        ),
                      ),
                    );
                  },
                ),
              ),
            ],
          ),
        );
      },
    );
  }
}
