import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/bloc/cubit/intership_cubit.dart';
import 'package:intership_frontend/components/calendar_button.dart';
import 'package:intership_frontend/components/list_week.dart';
import 'package:intership_frontend/screens/company/post_intership.dart';
import 'package:intership_frontend/services/globals.dart';
import 'package:intl/intl.dart';

import '../../../bloc/states/intership_state.dart';
import '../post2_intership_company.dart';

class WraperPostIntership extends StatelessWidget {
  List<String> sele = [];
  @override
  Widget build(BuildContext context) {
    return BlocBuilder<IntershipCubit, IntershipState>(
        builder: (context, state) {
      final listaCarreras = state.listaCarreras;
      final listaDays = state.dias;
      return Padding(
        padding: EdgeInsets.all(20),
        child: SingleChildScrollView(
          child: Column(
            children: <Widget>[
              TextFormField(
                decoration: InputDecoration(
                  hintText: "Titulo pasantia",
                  hintStyle: TextStyle(color: Colors.grey),
                  icon: Icon(Icons.work),
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(10),
                  ),
                ),
                onChanged: (value) {
                  BlocProvider.of<IntershipCubit>(context)
                      .updateNombrePasantia(value);
                },
              ),
              SizedBox(
                height: 20,
              ),
              DropdownButtonFormField(
                items: departments.map((String value) {
                  return DropdownMenuItem<String>(
                    value: value,
                    child: Text(value),
                  );
                }).toList(),
                hint:
                    Text("Departamento", style: TextStyle(color: Colors.grey)),
                icon: Icon(Icons.arrow_drop_down),
                onChanged: (value) {
                  BlocProvider.of<IntershipCubit>(context)
                      .updateDepartamento(value ?? '');
                },
              ),
              SizedBox(
                height: 20,
              ),
              Container(
                child: CalendarButton(),
              ),
              SizedBox(
                height: 20,
              ),
              Container(
                child: DaySelectionList(),
              ),
              SizedBox(
                height: 20,
              ),
              TextFormField(
                decoration: InputDecoration(
                  hintText: "Duración (Horas)",
                  icon: Icon(Icons.today),
                  hintStyle: TextStyle(color: Colors.grey),
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(10),
                  ),
                ),
                inputFormatters: [FilteringTextInputFormatter.digitsOnly],
                onChanged: (value) {
                  int horas = int.tryParse(value) ?? 0;
                  BlocProvider.of<IntershipCubit>(context).updateHoras(horas);
                },
              ),
              SizedBox(
                height: 20,
              ),
              TextFormField(
                decoration: InputDecoration(
                  hintText: 'Hora inicio',
                  icon: Icon(Icons.timer),
                  hintStyle: TextStyle(color: Colors.grey),
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(10),
                  ),
                ),
              ),
              SizedBox(
                height: 20,
              ),
              TextFormField(
                decoration: InputDecoration(
                  hintText: 'Hora final',
                  icon: Icon(Icons.timer),
                  hintStyle: TextStyle(color: Colors.grey),
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(10),
                  ),
                ),
              ),
              SizedBox(
                height: 20,
              ),
              TextFormField(
                decoration: InputDecoration(
                  hintText: 'Requerimientos',
                  icon: Icon(Icons.description),
                  hintStyle: TextStyle(color: Colors.grey),
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(10),
                  ),
                ),
                onChanged: (value) {
                  BlocProvider.of<IntershipCubit>(context)
                      .updateRequisitos(value);
                },
              ),
              SizedBox(
                height: 30,
              ),
              ElevatedButton(
                onPressed: () {
                  BlocProvider.of<IntershipCubit>(context).updateDias(sele);
                  Navigator.push(
                      context,
                      MaterialPageRoute(
                          builder: (context) => PostIntership2()));
                },
                child: Text("Continuar"),
                style: ElevatedButton.styleFrom(
                  primary: Colors.blue.shade900,
                  onPrimary: Colors.white,
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(10),
                  ),
                ),
              ),
            ],
          ),
        ),
      );
    });
  }
}
