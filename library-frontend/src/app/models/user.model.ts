export class User {
  userid: string = '';
  firstName: string = '';
  lastName: string = '';
  email: string = '';
  phone: string = '';
  password: string = '';
  address: string = '';
  role: UserRole = UserRole.STUDENT;
  enabled: boolean = true;
}

export enum UserRole {
  ADMIN = 'ADMIN',
  LIBRARIAN = 'LIBRARIAN',
  STUDENT = 'STUDENT'
}
