/*
 * MODEL Class 
 * @Ib
 */

export class Book {
	id: Number;
	name: String;
	author: String;
	category: String;
	returnDate: Date;

	constructor(id: Number, name: String, author: String, category: String, returnDate: Date) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.category = category;
		this.returnDate = returnDate;
	}
}