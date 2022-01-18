export interface KeepScreenOnPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
