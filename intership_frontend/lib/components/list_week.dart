import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

import '../bloc/cubit/intership_cubit.dart';

class DaySelectionList extends StatefulWidget {
  @override
  _DaySelectionListState createState() => _DaySelectionListState();
}

class _DaySelectionListState extends State<DaySelectionList> {
  List<String> days = [
    'Lunes',
    'Martes',
    'Miercoles',
    'Jueves',
    'Viernes',
    'Sabado',
    'Domingo'
  ];
  List<String> selectedDays = [];
  final _keyform = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Material(
      child: DropdownButtonFormField<String>(
        items: days.map((String day) {
          return DropdownMenuItem<String>(
              value: day,
              child: SizedBox(
                  width: 200,
                  child: ListTile(
                      title: Text(day),
                      trailing:
                          selectedDays.contains(day) ? Icon(Icons.check) : null,
                      onTap: () {
                        if (selectedDays.contains(day)) {
                          selectedDays.remove(day);
                        } else {
                          selectedDays.add(day);
                          print(selectedDays);
                        }
                        BlocProvider.of<IntershipCubit>(context)
                            .updateDias(selectedDays);
                      })));
        }).toList(),
        hint: Text('Seleccionar dias'),
        icon: Icon(Icons.arrow_drop_down),
        onChanged: (value) {
          BlocProvider.of<IntershipCubit>(context).updateDias(selectedDays);
        },
      ),
    );
  }
}
