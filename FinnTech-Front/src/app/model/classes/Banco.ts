import { IBanco } from "../interfaces/IBanco";

export class Banco implements IBanco {
    id!: String;
    nome!: String;
}