import 'package:flutter/material.dart';

class CustomDropdownButton<T> extends StatelessWidget {
  final List<T> items;
  final T? value;
  final String hintText;
  final Widget icon;
  final ValueChanged<T?>? onChanged;

  const CustomDropdownButton({
    Key? key,
    required this.items,
    this.value,
    required this.hintText,
    required this.icon,
    required this.onChanged,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return DropdownButtonFormField<T>(
      items: items.map((T item) {
        return DropdownMenuItem<T>(
          value: value,
          child: Text(item.toString()),
        );
      }).toList(),
      value: value,
      hint: Text(hintText, style: TextStyle(color: Colors.grey)),
      icon: icon,
      onChanged: onChanged,
    );
  }
}
