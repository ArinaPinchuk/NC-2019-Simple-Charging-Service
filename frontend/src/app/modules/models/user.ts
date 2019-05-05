import {Role} from "./role";
import {Wallet} from "./wallet";
import {Status} from "./status";

export class User{
  userId: number;
  firstName: string;
  secondName: string;
  email: string;
  login: string;
  password: string;
  roleByRoleId: Role;
  walletsByWalletId: Wallet;
  statusByStatusId: Status;
}
