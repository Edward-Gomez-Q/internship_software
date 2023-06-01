import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'calendar.dart';

class CalendarButton extends StatefulWidget {
  @override
  _CalendarButtonState createState() => _CalendarButtonState();
}

class _CalendarButtonState extends State<CalendarButton> {
  bool _showCalendar = false;
  DateTime? selectedDay;

  void toggleCalendar() async {
    final selected = await showDatePicker(
      context: context,
      initialDate: DateTime.now(),
      firstDate: DateTime(2000),
      lastDate: DateTime(2100),
    );

    if (selected != null) {
      setState(() {
        selectedDay = selected;
        _showCalendar = false;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: ListView(
        shrinkWrap: true,
        children: [
          Row(
            children: [
              Expanded(
                child: TextField(
                  decoration: InputDecoration(
                    hintText: 'Fecha',
                    icon: Icon(Icons.calendar_month),
                    hintStyle: TextStyle(color: Colors.grey.shade600),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                  controller: TextEditingController(
                    text: selectedDay != null
                        ? DateFormat('dd/MM/yyyy').format(selectedDay!)
                        : '',
                  ),
                ),
              ),
              SizedBox(
                width: 20,
              ),
              Column(children: [
                ElevatedButton(
                  child: Text('Fecha'),
                  onPressed: toggleCalendar,
                  style: ElevatedButton.styleFrom(
                    primary: Colors.blue.shade900,
                    onPrimary: Colors.white,
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                ),
                Visibility(
                  visible: _showCalendar,
                  child: SizedBox(
                    width: 300,
                    height: 300,
                    child: ListView(
                      shrinkWrap: true,
                      children: [
                        CalendarPicker(),
                      ],
                    ),
                  ),
                ),
              ]),
            ],
          ),
        ],
      ),
    );
  }
}
