package commons.services;

import lombok.Getter;

@Getter
public enum LogColor {
  RESET("\u001B[0m"),
  RED("\u001B[31m"),
  GREEN("\u001B[32m"),
  BLUE("\u001B[34m"),
  YELLOW("\u001B[33m"),
  SKY("\u001B[38;5;123m"),
  WHITE_CURSIVE("\u001B[3;37m"),
  TITLE("\u001B[1;34m"),
  TITLE2("\u001B[7;1;34m"),
  ERROR("\u001B[1;37;41m"),
  INFO("\u001B[36m"),
  DIVIDER("\u001B[1;35m"),
  YELLOW_SHINE("\u001B[1;33m");

  private final String color;

  LogColor(String color) {
    this.color = color;
  }
}
