import { IUser } from "../interfaces/IUser";

export class User implements IUser {
    email!: String;
    senha!: String;
}