import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Role} from "../modules/models/role";

@Injectable()
// Data service
export class RoleService { //todo create interface

  constructor(private http: HttpClient) {
  }

  // Ajax request for billing account data
  getRole(): Observable<Role[]> {
    return this.http.get<Role[]>('/api/role');
  }

  saveRole(role: Role): Observable<Role> {
    return this.http.post<Role>('/api/role', role);
  }

  deleteRole(roleId: string): Observable<void> {
    return this.http.delete<void>('/api/role/' + roleId);
  }

  getRoleById(id: string): Observable<Role> {
    return this.http.get<Role>('/api/role/' + id);
  }

}
