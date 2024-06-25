export interface Reward {
    id?: number; //? -> making it optional
    category: string;
    name: string;
    description: string;
    pointValue: number;
  }