import {AbstractControl, FormControl, ValidationErrors} from '@angular/forms';

export function validateDate(control: AbstractControl): ValidationErrors | null {
  const birthday = new Date(control.value);
  // tslint:disable-next-line:triple-equals
  if (_calculateAge(birthday) == 1) {
    return { dateValid : true };
  }
  return null;
}

function _calculateAge(birthday) { // birthday is a date
  const ageDifMs = Date.now() - birthday.getTime();
  const ageDate = new Date(ageDifMs); // miliseconds from epoch
  return Math.abs(ageDate.getUTCFullYear() - 1970);
}
