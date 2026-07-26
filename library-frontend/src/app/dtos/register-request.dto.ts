import {UserRole} from "../models/user.model";

export interface RegisterRequest {
  userid: string;
  firstName: string;
  lastName: string;
  email: string;
  phone: string;
  password: string;
  address?: string;
  role?: UserRole;
}
