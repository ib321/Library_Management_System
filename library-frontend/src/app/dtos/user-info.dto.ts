import {UserRole} from "../models/user.model";

export interface UserInfo {
  userId: string;
  firstName: string;
  lastName: string;
  email: string;
  phone: string;
  address: string;
  role: UserRole;
  enabled: boolean;
}
