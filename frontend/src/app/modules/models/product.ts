import {User} from "./user";

export interface Product{
  productId:string;
  name:string;
  price:string;
  shortDescription:string;
  longDescription:string;
  image: string;
  usersByCreatorId: User;
}
